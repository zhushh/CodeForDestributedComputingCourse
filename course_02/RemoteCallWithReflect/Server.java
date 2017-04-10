import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.reflect.*;

public class Server {
    private Map remoteObjects = new HashMap();

    public void register(String className, Object remoteObject) {
        remoteObjects.put(className, remoteObject);
    }

    public void service() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Service is starting...");

        while (true) {
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(in);
            OutputStream out = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            RemoteCall remotecallobj = (RemoteCall)ois.readObject();
            System.out.println(remotecallobj);
            remotecallobj = invoke(remotecallobj);

            oos.writeObject(remotecallobj);
            ois.close();
            oos.close();
            socket.close();
        }
    }

    public RemoteCall invoke(RemoteCall call) {
        Object result = null;
        try {
            String className = call.getClassName();
            String methodName = call.getMethodName();
            Object[] params = call.getParams();
            Class classType = Class.forName(className);
            Class[] paramTypes = call.getParamTypes();
            Method method = classType.getMethod(methodName,paramTypes);
            Object remoteObject = remoteObjects.get(className);

            if (remoteObject == null) {
                throw new Exception(className+" does not exist.");
            } else {
                result = method.invoke(remoteObject,params);
            }
        } catch (Exception e) {
            result = e;
        }

        call.setResult(result);
        return call;
    }

    public static void main(String args[]) throws Exception {
        Server server=new Server();
        server.register("AccountService", new AccountServiceImpl());
        server.service();
    }
}

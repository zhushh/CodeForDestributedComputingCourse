import java.io.*;
import java.net.*;

public class Connector {
    private String host;
    private int port;
    private Socket skt;
    private InputStream in;
    private ObjectInputStream ois;
    private OutputStream out;
    private ObjectOutputStream oos;

    public Connector(String host, int port) throws Exception {
        this.host = host;
        this.port = port;
        connect(host, port);
    }

    public void send(Object obj) throws Exception {
        oos.writeObject(obj);
    }

    public Object receive() throws Exception {
        return ois.readObject();
    }

    public void connect() throws Exception {
        connect(host, port);
    }

    public void connect(String host, int port) throws Exception {
        skt = new Socket(host, port);
        out = skt.getOutputStream();
        oos = new ObjectOutputStream(out);
        in = skt.getInputStream();
        ois = new ObjectInputStream(in);
    }

    public void close() {
        try {
            ois.close();
            oos.close();
            skt.close();
        } catch (Exception e) {
            System.out.println("Connector.close: " + e);
        }
    }
}

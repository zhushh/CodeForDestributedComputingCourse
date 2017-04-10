import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: EchoServer <Port>");
            return;
        }

        ServerSocket server = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("Listening on port: " + args[0]);

        Socket client = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());

        String str;
        System.out.println("Client is connected!");
        while ((str = in.readLine()) != null) {
            System.out.println(str);
            System.out.println("Receive: " + str);
            out.println("Server received: " + str);
            out.flush();
            if (str.equals("end")) {
                System.out.println("Communication is end!");
                break;
            }
        }

        out.close();
        in.close();
        client.close();
    }
}

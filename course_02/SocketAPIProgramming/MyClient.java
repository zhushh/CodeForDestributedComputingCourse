import java.net.*;
import java.io.*;

public class MyClient {
    static Socket server;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: MyClient <Host> <Port>");
            return;
        }

        server = new Socket(args[0], Integer.parseInt(args[1]));
        System.out.println("Connect to " + args[0] + ":" + args[1] + " success");

        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter out = new PrintWriter(server.getOutputStream());
        BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = wt.readLine();
            out.println(str);
            out.flush();
            if (str.equals("end")) {
                System.out.println("Communication is end!");
                break;
            }

            System.out.println(in.readLine());
        }

        wt.close();
        out.close();
        in.close();
        server.close();
    }
}

/*************************************************************************
 > File Name: EchoClient.java
 > Author: zhushh
 > Mail: 
 > Created Time: Thu 13 Apr 2017 10:41:53 PM CST
 ************************************************************************/

import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: EchoClient <Host> <Port>");
            return;
        }

        Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
        System.out.println("Current socket info: " + socket);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while ((userInput = stdin.readLine()) != null) {
            out.println(userInput);
            System.out.println("Return from server: " + in.readLine());
        }

        stdin.close();
        out.close();
        in.close();
        socket.close();
    }
}

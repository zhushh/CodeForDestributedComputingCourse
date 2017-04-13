/*************************************************************************
 > File Name: EchoServer.java
 > Author: zhushh
 > Mail: 
 > Created Time: Thu 13 Apr 2017 10:42:21 PM CST
 ************************************************************************/

import java.net.*;
import java.io.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: EchoServer <Port>");
            return ;
        }

        ServerSocket listenSocket = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("Server is listenning on port " + args[0]);
        Socket socket = listenSocket.accept();
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Receive: " + message);
            out.println(message.toUpperCase());
        }

        out.close();
        in.close();
        socket.close();
        listenSocket.close();
    }
}


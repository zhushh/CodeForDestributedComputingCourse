/*************************************************************************
 > File Name: MTEchoServer.java
 > Author: zhushh
 > Mail: 
 > Created Time: Thu 13 Apr 2017 10:43:24 PM CST
 ************************************************************************/

import java.net.*;
import java.io.*;

public class MTEchoServer {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: MTEchoServer <Port>");
            return;
        }

        ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
        System.out.println("Server is listenning on port " + args[0]);
        for (;;) {
            new EchoThread(ss.accept()).start();
        }
    }
}

class EchoThread extends Thread {
    Socket socket;
    EchoThread(Socket s) {
        socket = s;
    }

    public void run() {
        System.out.println("Server is starting serve " + socket);
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(socket + " request: " + message);
                out.println(message.toUpperCase());
            }

            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

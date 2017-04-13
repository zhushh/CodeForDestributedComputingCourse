/*************************************************************************
 > File Name: DaytimeServer2.java
 > Author: zhushh
 > Mail: 
 > Created Time: Fri 14 Apr 2017 01:24:06 AM CST
 ************************************************************************/

import java.io.*;
import java.net.*;
import java.util.Date;

public class DaytimeServer2 {
    public static void main(String[] args) {
        int serverPort = 13;
        if (args.length == 1) serverPort = Integer.parseInt(args[0]);
        try {
            ServerSocket myConnectionSocket = new ServerSocket(serverPort);
            System.out.println("Server is ready");
            while (true) {
                System.out.println("Wait the request from client.");
                MyStreamSocket myDataSocket = new MyStreamSocket(myConnectionSocket.accept());
                System.out.println("Connection is setup");
                Date timestamp = new Date();
                System.out.println("timestamp sent: " + timestamp.toString());
                myDataSocket.sendMessage(timestamp.toString());
                myDataSocket.close();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

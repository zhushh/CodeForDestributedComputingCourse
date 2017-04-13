/*************************************************************************
 > File Name: DaytimeServer1.java
 > Author: zhushh
 > Mail: 
 > Created Time: Thu 13 Apr 2017 11:29:30 PM CST
 ************************************************************************/

import java.io.*;
import java.util.Date;

public class DaytimeServer1 {
    public static void main(String[] args) {
        int serverPort = 13;
        if (args.length == 1) {
            serverPort = Integer.parseInt(args[0]);
        }

        try {
            MyServerDatagramSocket mySocket = new MyServerDatagramSocket(serverPort);
            System.out.println("Server is ready");

            while (true) {
                DatagramMessage request = mySocket.receiveMessageAndSender();
                System.out.println("Receive request from client");
                Date timestamp = new Date();
                System.out.println("timestamp sent: " + timestamp.toString());
                mySocket.sendMessage(request.getAddress(), request.getPort(), timestamp.toString());
            }
        } catch (Exception e) {
            System.out.println("Problem: " + e);
        }
    }
}

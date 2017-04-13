/*************************************************************************
 > File Name: DaytimeClientHelper1.java
 > Author: zhushh
 > Mail: 
 > Created Time: Thu 13 Apr 2017 11:30:10 PM CST
 ************************************************************************/

import java.net.*;

public class DaytimeClientHelper1 {
    public static String getTimestamp(String hostName, String portNum) {
        String timestamp = "";
        try {
            InetAddress serverHost = InetAddress.getByName(hostName);
            int serverPort = Integer.parseInt(portNum);
            MyDatagramSocket mySocket = new MyDatagramSocket();
            mySocket.sendMessage(serverHost, serverPort, "");
            timestamp = mySocket.receiveMessage();
            mySocket.close();
        } catch(Exception e) {
            System.out.println("Problem: " + e);
        }
        return timestamp;
    }
}

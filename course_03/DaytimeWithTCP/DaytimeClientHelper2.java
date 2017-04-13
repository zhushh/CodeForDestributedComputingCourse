/*************************************************************************
 > File Name: DaytimeClientHelper2.java
 > Author: zhushh
 > Mail: 
 > Created Time: Fri 14 Apr 2017 01:24:51 AM CST
 ************************************************************************/

import java.net.*;

public class DaytimeClientHelper2 {
    public static String getTimestamp(String hostName, String portNum) throws Exception {
        String timestamp = "";
        InetAddress serverHost = InetAddress.getByName(hostName);
        int serverPort = Integer.parseInt(portNum);
        MyStreamSocket mySocket = new MyStreamSocket(serverHost, serverPort);
        timestamp = mySocket.receiveMessage();
        mySocket.close();
        return timestamp;
    }
}

/*************************************************************************
 > File Name: DatagramMessage.java
 > Author: zhushh
 > Mail: 
 > Created Time: Thu 13 Apr 2017 11:28:33 PM CST
 ************************************************************************/

import java.net.*;

public class DatagramMessage {
    private String message;
    private InetAddress senderAddress;
    private int senderPort;

    public void putValue(String message, InetAddress addr, int port) {
        this.message = message;
        this.senderAddress = addr;
        this.senderPort = port;
    }

    public String getMessage() {
        return this.message;
    }

    public InetAddress getAddress() {
        return this.senderAddress;
    }

    public int getPort() {
        return this.senderPort;
    }
}

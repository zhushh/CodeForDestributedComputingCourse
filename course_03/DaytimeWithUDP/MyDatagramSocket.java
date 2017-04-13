/*************************************************************************
 > File Name: MyDatagramSocket.java
 > Author: zhushh
 > Mail: 
 > Created Time: Thu 13 Apr 2017 11:30:26 PM CST
 ************************************************************************/

import java.net.*;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import java.io.*;

public class MyDatagramSocket extends DatagramSocket {
    static final int MAX_LEN = 100;
    MyDatagramSocket() throws SocketException {
        super();
    }

    MyDatagramSocket(int portNo) throws SocketException {
        super(portNo);
    }

    public void sendMessage(InetAddress receiverHost, int receiverPort, String message) throws IOException {
        byte[] sendBuffer = message.getBytes();
        DatagramPacket datagram = new DatagramPacket(sendBuffer, sendBuffer.length, receiverHost, receiverPort);
        this.send(datagram);
    }

    public String receiveMessage() throws IOException {
        byte[] receiveBuffer = new byte[MAX_LEN];
        DatagramPacket datagram = new DatagramPacket(receiveBuffer, MAX_LEN);
        this.receive(datagram);
        String message = new String(receiveBuffer);
        return message;
    }
}

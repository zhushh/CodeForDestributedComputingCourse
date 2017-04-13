/*************************************************************************
 > File Name: DaytimeClient1.java
 > Author: zhushh
 > Mail: 
 > Created Time: Thu 13 Apr 2017 11:28:56 PM CST
 ************************************************************************/

import java.io.*;

public class DaytimeClient1 {
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        try {
            System.out.println("Please input server hostname: ");
            String hostName = br.readLine();
            if (hostName.length() == 0) hostName = "localhost";
            System.out.println("Please input server port: ");
            String portNum  = br.readLine();
            if (portNum.length() == 0) portNum = "13";
            System.out.println(DaytimeClientHelper1.getTimestamp(hostName, portNum));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

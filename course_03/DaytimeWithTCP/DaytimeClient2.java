/*************************************************************************
 > File Name: DaytimeClient2.java
 > Author: zhushh
 > Mail: 
 > Created Time: Fri 14 Apr 2017 01:24:37 AM CST
 ************************************************************************/

import java.io.*;

public class DaytimeClient2 {
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        try {
            System.out.println("Please input server hostname: ");
            String hostName = br.readLine();
            System.out.println("Please input server port: ");
            String portNum = br.readLine();
            if (portNum.length() == 0) portNum = "13";
            System.out.println(DaytimeClientHelper2.getTimestamp(hostName, portNum));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

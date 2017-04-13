package annotation.demo;

import java.net.*;
import java.io.*;
import java.util.*;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket((args.length==0)?80:Integer.parseInt(args[0]));
        System.out.println("Http service is ready ...");
        while (true) {
            new HttpThread(ss.accept()).start();
        }
    }
}

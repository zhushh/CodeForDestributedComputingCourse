package annotation.demo;

import java.net.*;
import java.io.*;
import java.util.*;

public class HttpThread extends Thread {
    Socket socket;
    HttpThread(Socket s) {
        socket = s;
    }

    public void run() {
        try {
            // open connection input and output stream
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK"));
            OutputStream out = socket.getOutputStream();
            // read request
            String request = in.readLine();
            System.out.println("Receive request: " + request);
            // Deal with Get method
            StringTokenizer st = new StringTokenizer(request);
            if ((st.countTokens() >= 2) && st.nextToken().equals("GET")) {
                String filename = st.nextToken();
                String path = "/";
                String fruitName = "";

                if (filename.endsWith("/")) filename = filename.substring(0, filename.length() - 1);
                if (!filename.startsWith("/")) filename = "/" + filename;

                if (!filename.equals("/")) {
                    int i = filename.length() - 1;
                    while (filename.charAt(i) != '/') {
                        i--;
                    }
                    i++;

                    path = filename.substring(0, i);
                    fruitName = filename.substring(i, filename.length());
                }

                try {
                    String fruitInfo = FruitInfoUtil.getFruitInfo(FruitService.class, path, fruitName);

                    String response = "HTTP/1.1 200 OK\nContent-Type: text/html\n\n";
                    response += fruitInfo;
                    out.write(response.getBytes());
                    out.flush();
                } catch (FileNotFoundException ex) {
                    PrintWriter pout = new PrintWriter(new OutputStreamWriter(out, "GBK"), true);
                    pout.println("Error code 404: not found!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                PrintWriter pout = new PrintWriter(new OutputStreamWriter(out, "GBK"), true);
                pout.println("Error code 404: wrong request!");
            }
            socket.close();
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex);
        }
    }
}


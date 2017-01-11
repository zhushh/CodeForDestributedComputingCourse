package org.example;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class DynamicClient {

    public static void main(String[] args) {
        try {
            URL wsdl = new URL("http://localhost:8080/ws/soap/hello?wsdl");
            QName serviceName = new QName("http://example.org/", "HelloService");
            QName portName = new QName("http://example.org/", "HelloServicePort");
            Service service = Service.create(wsdl, serviceName);

            HelloService helloService = service.getPort(portName, HelloService.class);
            String result = helloService.say("world");
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

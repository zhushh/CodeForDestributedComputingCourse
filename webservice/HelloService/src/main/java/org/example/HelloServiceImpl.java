package org.example;

import javax.jws.WebService;

@WebService(
    serviceName = "HelloService",
    portName = "HelloServicePort",
    endpointInterface = "org.example.HelloService"
)
public class HelloServiceImpl implements HelloService {
    public String say(String name) {
        return "Hello, " + name;
    }
}

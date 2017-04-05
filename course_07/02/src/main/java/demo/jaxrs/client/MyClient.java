package demo.jaxrs.client;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Configurable;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.Entity;

public final class MyClient {

    private MyClient() {
    }

    public static void main(String args[]) throws Exception {

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:9000/customerservice/");
        WebTarget customers = webTarget.path("customers");
        WebTarget orders = webTarget.path("orders");

        // // Sent HTTP GET request to query customer info
        System.out.println("Sent HTTP GET request to query customer info");
        System.out.println(customers.path("123").request().get(String.class));

        // Sent HTTP PUT request to update customer info
        System.out.println("\n");
        System.out.println("Sent HTTP PUT request to update customer info");
        MyClient myClient = new MyClient();
        String inputFile = myClient.getClass().getResource("/update_customer.xml").getFile();
        String fileContent = readStringFromFile(inputFile);

        Response response = customers.request(MediaType.APPLICATION_XML_TYPE)
                                        .put(Entity.entity(fileContent, MediaType.APPLICATION_XML_TYPE));

        System.out.println("Response status code: " + response.getStatus());
        System.out.println("Response body: ");
        System.out.println(response.readEntity(String.class));

        // Sent HTTP POST request to add customer
        System.out.println("\n");
        System.out.println("Sent HTTP POST request to add customer");
        inputFile = myClient.getClass().getResource("/add_customer.xml").getFile();
        fileContent = readStringFromFile(inputFile);

        response = customers.request(MediaType.APPLICATION_XML_TYPE)
                                .post(Entity.entity(fileContent, MediaType.APPLICATION_XML_TYPE));

        System.out.println("Response status code: " + response.getStatus());
        System.out.println("Response body: ");
        System.out.println(response.readEntity(String.class));

        System.out.println("\n");
        System.exit(0);
    }

    private static String readStringFromFile(String filename) throws Exception {
        String contents = "";
        BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                contents += line;
            }
        } finally {
        }
        return contents;
    }
}

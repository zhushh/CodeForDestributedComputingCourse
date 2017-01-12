package org.me.example.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;

import demo.jaxrs.server.Customer;

@Path("/hello/{username}")
public class Hello {

    @GET
    @Produces("text/xml")
    public String sayHello(@PathParam("username") String userName) {
            return "hello " + userName;
    }

    @POST
    @Consumes("text/plain")
    @Produces("text/xml")
    public String sayHello(@PathParam("username") String userName, String letter) {
            return "hello " + userName + ":" + letter;
    }

    @GET
    @Path("/girlfriend")
    @Produces("text/html")
    public String girlFriend(@PathParam("username") String userName,
                    @DefaultValue("Mary") @QueryParam("name") String name,
                    @DefaultValue("123") @QueryParam("id") String id) {
            return "hello " + userName + ": your's gf is " + name;
    }

    @POST
    @Path("/girlfriend")
    @Produces("text/html")
    public String girlFriendPost(@PathParam("username") String userName,
                    @FormParam("") Customer user ) {
            return "hello " + userName + ": your's gf is " + user.getName();
    }

}

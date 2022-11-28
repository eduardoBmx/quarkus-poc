package br.com.edu.controller;

import br.com.edu.entity.Order;
import br.com.edu.service.OrderService;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestPath;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    OrderService service;

    @POST
    public Uni<Order> save(Order order) {
        return service.save(order);
    }

    @GET
    public Uni<List<Order>> getAll(){
        return service.getAll();
    }

    @GET()
    @Path("/{id}")
    public Uni<Order> getById(@RestPath("id") Long id){
        return service.getById(id);
    }
}
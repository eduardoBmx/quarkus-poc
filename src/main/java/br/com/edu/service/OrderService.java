package br.com.edu.service;

import br.com.edu.entity.Order;
import br.com.edu.repository.OrderRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    public Uni<Order> save(Order order) {
        return orderRepository.persist(order);
    }

    public Uni<List<Order>> getAll() {
        return orderRepository.findAll().list();
    }

    public Uni<Order> getById(Long id) {
        return orderRepository.findById(id);
    }
}

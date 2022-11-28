package br.com.edu.repository;

import br.com.edu.entity.Order;
import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OrderRepositoryImpl{

    @Inject
    Mutiny.SessionFactory sf;

    public Uni<Order> saveOrder(Order order) {
        return sf.withTransaction((s, t) -> s.persist(order)).replaceWith(order);
    }

    public Uni<List<Order>> getAll() {
        return sf.withTransaction((s, t) -> s.createNamedQuery("Order.findAll", Order.class).getResultList());
    }

    public Uni<Order> getById(Long id) {
        return sf.withTransaction((s, t) -> s.find(Order.class, id));
    }
}

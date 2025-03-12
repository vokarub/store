package ru.flowstory.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flowstory.store.models.Order;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByCustomerMobile(String customerMobile);
    Optional<Order> findByCustomerName(String customerName);
}
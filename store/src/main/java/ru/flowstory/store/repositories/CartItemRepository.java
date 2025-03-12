package ru.flowstory.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flowstory.store.models.CartItem;
import ru.flowstory.store.models.Order;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Order> {
    Optional<CartItem> findByProductName(String name);
}
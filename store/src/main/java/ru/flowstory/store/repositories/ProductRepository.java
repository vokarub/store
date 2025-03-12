package ru.flowstory.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.flowstory.store.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(String category);
    Optional<Product> findByName(String productName);
}

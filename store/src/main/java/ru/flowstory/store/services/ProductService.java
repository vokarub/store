package ru.flowstory.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.flowstory.store.models.Product;
import ru.flowstory.store.util.ProductNotFoundException;
import ru.flowstory.store.repositories.ProductRepository;
import ru.flowstory.store.util.UnknownEntityException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findOne(int id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.orElseThrow(ProductNotFoundException::new);
    }

    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product findByProductName(String productName) {
        Optional<Product> foundProduct = productRepository.findByName(productName);
        return foundProduct.orElseThrow(ProductNotFoundException::new);
    }

    public Product getProduct(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new UnknownEntityException(Product.class, productId));
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }
}

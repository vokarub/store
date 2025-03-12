package ru.flowstory.store.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.flowstory.store.dto.ProductDTO;
import ru.flowstory.store.models.Product;
import ru.flowstory.store.services.ProductService;
import ru.flowstory.store.util.ProductErrorResponse;
import ru.flowstory.store.util.ProductNotCreatedException;
import ru.flowstory.store.util.ProductNotFoundException;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductsController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductsController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<ProductDTO> getTop12Products() {
        return productService.findAll().stream()
                .filter(Product::isInStock)
                .limit(12)
                .map(this::convertToBouquetDTO).collect(Collectors.toList()); // top 12 flowers
    } 

    @GetMapping("/catalog")
    public List<ProductDTO> getFlowers() {
        return productService.findAll().stream()
                .filter(Product::isInStock)
                .map(this::convertToBouquetDTO).collect(Collectors.toList());  // jackson converts into JSON
    }

    @GetMapping("/catalog/{category}")
    public List<ProductDTO> getFlowersByCategory(@PathVariable("category") String category) {
        return productService.findAll().stream().filter(a -> Objects.equals(a.getCategory(), category))
                .filter(Product::isInStock)
                .map(this::convertToBouquetDTO).collect(Collectors.toList());

    }

    @ExceptionHandler
    private ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException e) {
        ProductErrorResponse response = new ProductErrorResponse(
                "Товар с таким айди не найден",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // 404
    }

    @ExceptionHandler
    private ResponseEntity<ProductErrorResponse> handleException(ProductNotCreatedException e) {
        ProductErrorResponse response = new ProductErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // 403
    }

    private Product convertToBouquet(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    private ProductDTO convertToBouquetDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
}

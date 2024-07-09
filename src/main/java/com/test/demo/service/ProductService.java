package com.test.demo.service;

import com.test.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Optional<Product> findById(Long id);

    List<Product> findAll();

    Product save(Product product);

    void deleteById(Long id);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByBrandContainingIgnoreCase(String brand);

    List<Product> findByColorContainingIgnoreCase(String color);
}

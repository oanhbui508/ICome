package com.test.demo.serviceImpl;

import com.test.demo.entity.Product;
import com.test.demo.repository.ProductRepository;
import com.test.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> findByBrandContainingIgnoreCase(String brand) {
        return productRepository.findByBrandContainingIgnoreCase(brand);
    }

    @Override
    public List<Product> findByColorContainingIgnoreCase(String color) {
        return productRepository.findByColorContainingIgnoreCase(color);
    }
}

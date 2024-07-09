package com.test.demo.controller;

import com.test.demo.entity.Product;
import com.test.demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductControllerTest {
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        // Mock data
        List<Product> mockProducts = Arrays.asList(
                new Product(1L, "Product A", new BigDecimal("99.99"), "Brand X", "Red"),
                new Product(2L, "Product B", new BigDecimal("149.99"), "Brand Y", "Blue")
        );

        // Mock the service method
        when(productService.findAll()).thenReturn(mockProducts);

        // Call the controller method
        ResponseEntity<List<Product>> response = productController.getAllProducts();

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProducts.size(), response.getBody().size());
    }

    @Test
    public void testGetProductById() {
        // Mock data
        Long productId = 1L;
        Product mockProduct = new Product(productId, "Product A", new BigDecimal("99.99"), "Brand X", "Red");

        // Mock the service method
        when(productService.findById(productId)).thenReturn(Optional.of(mockProduct));

        // Call the controller method
        ResponseEntity<Product> response = productController.getProductById(productId);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProduct, response.getBody());
    }

    @Test
    public void testGetProductByIdNotFound() {
        // Mock data
        Long productId = 1L;

        // Mock the service method
        when(productService.findById(productId)).thenReturn(Optional.empty());

        // Call the controller method
        ResponseEntity<Product> response = productController.getProductById(productId);

        // Verify the response
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testCreateProduct() {
        // Mock data
        Product mockProduct = new Product(null, "New Product", new BigDecimal("199.99"), "Brand Z", "Green");
        Product savedProduct = new Product(1L, "New Product", new BigDecimal("199.99"), "Brand Z", "Green");

        // Mock the service method
        when(productService.save(any(Product.class))).thenReturn(savedProduct);

        // Call the controller method
        ResponseEntity<Product> response = productController.createProduct(mockProduct);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(savedProduct, response.getBody());
    }

    @Test
    public void testUpdateProduct() {
        // Mock data
        Long productId = 1L;
        Product existingProduct = new Product(productId, "Existing Product", new BigDecimal("299.99"), "Brand A", "Yellow");
        Product updatedProduct = new Product(productId, "Updated Product", new BigDecimal("399.99"), "Brand B", "Blue");

        // Mock the service methods
        when(productService.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productService.save(any(Product.class))).thenReturn(updatedProduct);

        // Call the controller method
        ResponseEntity<Product> response = productController.updateProduct(productId, updatedProduct);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProduct, response.getBody());
    }

    @Test
    public void testUpdateProductNotFound() {
        // Mock data
        Long productId = 1L;
        Product updatedProduct = new Product(productId, "Updated Product", new BigDecimal("399.99"), "Brand B", "Blue");

        // Mock the service method
        when(productService.findById(productId)).thenReturn(Optional.empty());

        // Call the controller method
        ResponseEntity<Product> response = productController.updateProduct(productId, updatedProduct);

        // Verify the response
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testDeleteProduct() {
        // Mock data
        Long productId = 1L;

        // Call the controller method
        ResponseEntity<Void> response = productController.deleteProduct(productId);

        // Verify the response
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(productService, times(1)).deleteById(productId);
    }
}

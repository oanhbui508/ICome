package com.test.demo.serviceImplTest;

import com.test.demo.entity.Product;
import com.test.demo.repository.ProductRepository;
import com.test.demo.serviceImpl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
        product.setId(1L);
        product.setName("Product A");
        product.setPrice(new BigDecimal("19.99"));
        product.setBrand("Brand A");
        product.setColor("Red");
    }

    @Test
    public void testFindById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> found = productService.findById(1L);

        assertNotNull(found);
        assertEquals("Product A", found.get().getName());
        verify(productRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindAll() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product));

        List<Product> products = productService.findAll();

        assertNotNull(products);
        assertEquals(1, products.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testSave() {
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product saved = productService.save(product);

        assertNotNull(saved);
        assertEquals("Product A", saved.getName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(productRepository).deleteById(1L);

        productService.deleteById(1L);

        verify(productRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testFindByNameContainingIgnoreCase() {
        when(productRepository.findByNameContainingIgnoreCase("product")).thenReturn(Arrays.asList(product));

        List<Product> products = productService.findByNameContainingIgnoreCase("product");

        assertNotNull(products);
        assertEquals(1, products.size());
        verify(productRepository, times(1)).findByNameContainingIgnoreCase("product");
    }

    @Test
    public void testFindByBrandContainingIgnoreCase() {
        when(productRepository.findByBrandContainingIgnoreCase("brand")).thenReturn(Arrays.asList(product));

        List<Product> products = productService.findByBrandContainingIgnoreCase("brand");

        assertNotNull(products);
        assertEquals(1, products.size());
        verify(productRepository, times(1)).findByBrandContainingIgnoreCase("brand");
    }

    @Test
    public void testFindByColorContainingIgnoreCase() {
        when(productRepository.findByColorContainingIgnoreCase("red")).thenReturn(Arrays.asList(product));

        List<Product> products = productService.findByColorContainingIgnoreCase("red");

        assertNotNull(products);
        assertEquals(1, products.size());
        verify(productRepository, times(1)).findByColorContainingIgnoreCase("red");
    }
}

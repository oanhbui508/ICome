package com.test.demo.entityTest;

import com.test.demo.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductTest {
    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
    }

    @Test
    public void testGettersAndSetters() {
        Long id = 1L;
        String name = "Product Name";
        BigDecimal price = new BigDecimal("99.99");
        String brand = "Brand Name";
        String color = "Color Name";

        assertNull(product.getId()); // The initial id should be null
        product.setId(id);
        assertEquals(id, product.getId());

        assertNull(product.getName());
        product.setName(name);
        assertEquals(name, product.getName());

        assertNull(product.getPrice());
        product.setPrice(price);
        assertEquals(price, product.getPrice());

        assertNull(product.getBrand());
        product.setBrand(brand);
        assertEquals(brand, product.getBrand());

        assertNull(product.getColor());
        product.setColor(color);
        assertEquals(color, product.getColor());
    }

    @Test
    public void testParameterizedConstructor() {
        Long id = 1L;
        String name = "Product Name";
        BigDecimal price = new BigDecimal("99.99");
        String brand = "Brand Name";
        String color = "Color Name";

        Product parameterizedProduct = new Product(id, name, price, brand, color);

        assertEquals(id, parameterizedProduct.getId());
        assertEquals(name, parameterizedProduct.getName());
        assertEquals(price, parameterizedProduct.getPrice());
        assertEquals(brand, parameterizedProduct.getBrand());
        assertEquals(color, parameterizedProduct.getColor());
    }
}

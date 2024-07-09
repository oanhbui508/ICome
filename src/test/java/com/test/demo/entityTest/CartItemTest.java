package com.test.demo.entityTest;

import com.test.demo.entity.Cart;
import com.test.demo.entity.CartItem;
import com.test.demo.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CartItemTest {
    private CartItem cartItem;

    @BeforeEach
    public void setUp() {
        cartItem = new CartItem();
    }

    @Test
    public void testGettersAndSetters() {
        Long id = 1L;
        Cart cart = new Cart();
        Product product = new Product();
        int quantity = 10;

        assertNull(cartItem.getId()); // The initial id should be null
        cartItem.setId(id);
        assertEquals(id, cartItem.getId());

        assertNull(cartItem.getCart());
        cartItem.setCart(cart);
        assertEquals(cart, cartItem.getCart());

        assertNull(cartItem.getProduct());
        cartItem.setProduct(product);
        assertEquals(product, cartItem.getProduct());

        assertEquals(0, cartItem.getQuantity());
        cartItem.setQuantity(quantity);
        assertEquals(quantity, cartItem.getQuantity());
    }

    @Test
    public void testParameterizedConstructor() {
        Long id = 1L;
        Cart cart = new Cart();
        Product product = new Product();
        int quantity = 10;

        CartItem parameterizedCartItem = new CartItem(id, cart, product, quantity);

        assertEquals(id, parameterizedCartItem.getId());
        assertEquals(cart, parameterizedCartItem.getCart());
        assertEquals(product, parameterizedCartItem.getProduct());
        assertEquals(quantity, parameterizedCartItem.getQuantity());
    }
}

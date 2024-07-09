package com.test.demo.entityTest;

import com.test.demo.entity.Cart;
import com.test.demo.entity.CartItem;
import com.test.demo.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CartTest {
    private Cart cart;

    @BeforeEach
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testGettersAndSetters() {
        Long id = 1L;
        Customer customer = new Customer();
        List<CartItem> cartItems = new ArrayList<>();

        assertNull(cart.getId()); // The initial id should be null
        cart.setId(id);
        assertEquals(id, cart.getId());

        assertNull(cart.getCustomer());
        cart.setCustomer(customer);
        assertEquals(customer, cart.getCustomer());

        assertNull(cart.getCartItems());
        cart.setCartItems(cartItems);
        assertEquals(cartItems, cart.getCartItems());
    }

    @Test
    public void testParameterizedConstructor() {
        Long id = 1L;
        Customer customer = new Customer();
        List<CartItem> cartItems = new ArrayList<>();

        Cart parameterizedCart = new Cart(id, customer, cartItems);

        assertEquals(id, parameterizedCart.getId());
        assertEquals(customer, parameterizedCart.getCustomer());
        assertEquals(cartItems, parameterizedCart.getCartItems());
    }
}

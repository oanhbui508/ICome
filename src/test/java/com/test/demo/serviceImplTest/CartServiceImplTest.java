package com.test.demo.serviceImplTest;

import com.test.demo.entity.Cart;
import com.test.demo.entity.Customer;
import com.test.demo.repository.CartRepository;
import com.test.demo.serviceImpl.CartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CartServiceImplTest {
    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    private Cart cart;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer();
        customer.setId(1L);
        cart = new Cart();
        cart.setId(1L);
        cart.setCustomer(customer);
    }

    @Test
    public void testFindByCustomer() {
        when(cartRepository.findByCustomer(any(Customer.class))).thenReturn(Arrays.asList(cart));

        List<Cart> carts = cartService.findByCustomer(customer);

        assertNotNull(carts);
        assertEquals(1, carts.size());
        verify(cartRepository, times(1)).findByCustomer(customer);
    }

    @Test
    public void testSave() {
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart saved = cartService.save(cart);

        assertNotNull(saved);
        assertEquals(cart.getId(), saved.getId());
        verify(cartRepository, times(1)).save(cart);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(cartRepository).deleteById(1L);

        cartService.deleteById(1L);

        verify(cartRepository, times(1)).deleteById(1L);
    }
}

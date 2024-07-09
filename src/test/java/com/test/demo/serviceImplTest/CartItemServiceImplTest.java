package com.test.demo.serviceImplTest;

import com.test.demo.entity.Cart;
import com.test.demo.entity.CartItem;
import com.test.demo.entity.Product;
import com.test.demo.repository.CartItemRepository;
import com.test.demo.serviceImpl.CartItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CartItemServiceImplTest {
    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private CartItemServiceImpl cartItemService;

    private CartItem cartItem;
    private Cart cart;
    private Product product;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cart = new Cart();
        product = new Product();
        cartItem = new CartItem();
        cartItem.setId(1L);
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
    }

    @Test
    public void testFindByCart() {
        when(cartItemRepository.findByCart(cart)).thenReturn(Arrays.asList(cartItem));

        List<CartItem> found = cartItemService.findByCart(cart);

        assertNotNull(found);
        assertEquals(1, found.size());
        verify(cartItemRepository, times(1)).findByCart(cart);
    }

    @Test
    public void testFindByProduct() {
        when(cartItemRepository.findByProduct(product)).thenReturn(Arrays.asList(cartItem));

        List<CartItem> found = cartItemService.findByProduct(product);

        assertNotNull(found);
        assertEquals(1, found.size());
        verify(cartItemRepository, times(1)).findByProduct(product);
    }

    @Test
    public void testSave() {
        when(cartItemRepository.save(any(CartItem.class))).thenReturn(cartItem);

        CartItem saved = cartItemService.save(cartItem);

        assertNotNull(saved);
        assertEquals(cartItem.getId(), saved.getId());
        verify(cartItemRepository, times(1)).save(cartItem);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(cartItemRepository).deleteById(cartItem.getId());

        cartItemService.deleteById(cartItem.getId());

        verify(cartItemRepository, times(1)).deleteById(cartItem.getId());
    }
}

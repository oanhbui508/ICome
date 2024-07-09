package com.test.demo.service;

import com.test.demo.entity.Cart;
import com.test.demo.entity.CartItem;
import com.test.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartItemService {
    List<CartItem> findByCart(Cart cart);

    List<CartItem> findByProduct(Product product);

    CartItem save(CartItem cartItem);

    void deleteById(Long id);
}

package com.test.demo.service;

import com.test.demo.entity.Cart;
import com.test.demo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    List<Cart> findByCustomer(Customer customer);

    Cart save(Cart cart);

    void deleteById(Long id);
}

package com.test.demo.serviceImpl;

import com.test.demo.entity.Cart;
import com.test.demo.entity.Customer;
import com.test.demo.repository.CartRepository;
import com.test.demo.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> findByCustomer(Customer customer) {
        return cartRepository.findByCustomer(customer);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }
}

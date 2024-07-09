package com.test.demo.repository;

import com.test.demo.entity.Cart;
import com.test.demo.entity.CartItem;
import com.test.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCart(Cart cart);

    List<CartItem> findByProduct(Product product);
}

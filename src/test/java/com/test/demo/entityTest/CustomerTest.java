package com.test.demo.entityTest;

import com.test.demo.entity.ActivityLog;
import com.test.demo.entity.Cart;
import com.test.demo.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CustomerTest {
    private Customer customer;

    @BeforeEach
    public void setUp() {
        customer = new Customer();
    }

    @Test
    public void testGettersAndSetters() {
        Long id = 1L;
        String name = "John Doe";
        String facebookId = "john.doe.facebook";
        List<ActivityLog> activityLogs = new ArrayList<>();
        List<Cart> carts = new ArrayList<>();

        assertNull(customer.getId()); // The initial id should be null
        customer.setId(id);
        assertEquals(id, customer.getId());

        assertNull(customer.getName());
        customer.setName(name);
        assertEquals(name, customer.getName());

        assertNull(customer.getFacebookId());
        customer.setFacebookId(facebookId);
        assertEquals(facebookId, customer.getFacebookId());

        assertNull(customer.getActivityLogs());
        customer.setActivityLogs(activityLogs);
        assertEquals(activityLogs, customer.getActivityLogs());

        assertNull(customer.getCarts());
        customer.setCarts(carts);
        assertEquals(carts, customer.getCarts());
    }

    @Test
    public void testParameterizedConstructor() {
        Long id = 1L;
        String name = "John Doe";
        String facebookId = "john.doe.facebook";
        List<ActivityLog> activityLogs = new ArrayList<>();
        List<Cart> carts = new ArrayList<>();

        Customer parameterizedCustomer = new Customer(name, id, facebookId, activityLogs, carts);

        assertEquals(id, parameterizedCustomer.getId());
        assertEquals(name, parameterizedCustomer.getName());
        assertEquals(facebookId, parameterizedCustomer.getFacebookId());
        assertEquals(activityLogs, parameterizedCustomer.getActivityLogs());
        assertEquals(carts, parameterizedCustomer.getCarts());
    }
}

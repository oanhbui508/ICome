package com.test.demo.serviceImplTest;

import com.test.demo.entity.Customer;
import com.test.demo.repository.CustomerRepository;
import com.test.demo.serviceImpl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceImplTest {
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindById() {
        Long customerId = 1L;
        Customer mockCustomer = new Customer("John Doe", customerId, "john.doe@example.com", null, null);
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));

        Optional<Customer> foundCustomer = customerService.findById(customerId);

        assertTrue(foundCustomer.isPresent());
        assertEquals("John Doe", foundCustomer.get().getName());
    }

    @Test
    public void testFindByFacebookId() {
        String facebookId = "fb123";
        Customer mockCustomer = new Customer("Jane Doe", 2L, facebookId, null, null);
        when(customerRepository.findByFacebookId(facebookId)).thenReturn(Optional.of(mockCustomer));

        Optional<Customer> foundCustomer = customerService.findByFacebookId(facebookId);

        assertTrue(foundCustomer.isPresent());
        assertEquals("Jane Doe", foundCustomer.get().getName());
    }

    @Test
    public void testFindByName() {
        String name = "Jane Doe";
        Customer mockCustomer = new Customer(name, 3L, "jane.doe@example.com", null, null);
        when(customerRepository.findByName(name)).thenReturn(Optional.of(mockCustomer));

        Optional<Customer> foundCustomer = customerService.findByName(name);

        assertTrue(foundCustomer.isPresent());
        assertEquals("jane.doe@example.com", foundCustomer.get().getFacebookId());    }

    @Test
    public void testFindAll() {
        Customer customer1 = new Customer("John Doe", 1L, "john.doe@example.com", null, null);
        Customer customer2 = new Customer("Jane Doe", 2L, "jane.doe@example.com", null, null);
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        List<Customer> customers = customerService.findAll();

        assertEquals(2, customers.size());
        assertEquals("Jane Doe", customers.get(1).getName());
    }

    @Test
    public void testSave() {
            Customer newCustomer = new Customer("New Customer", null, "new.customer@example.com", null, null);
            Customer savedCustomer = new Customer("New Customer", 4L, "new.customer@example.com", null, null);

            when(customerRepository.save(newCustomer)).thenReturn(savedCustomer);

            Customer result = customerService.save(newCustomer);

            assertNotNull(result);
            assertNotNull(result.getId());
    }

    @Test
    public void testDeleteById() {
        Long customerId = 1L;

        // Call service method
        customerService.deleteById(customerId);

        // Verify that deleteById method of customerRepository is called once
        verify(customerRepository, times(1)).deleteById(customerId);
    }
}

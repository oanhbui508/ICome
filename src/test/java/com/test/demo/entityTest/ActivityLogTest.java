package com.test.demo.entityTest;

import com.test.demo.entity.ActivityLog;
import com.test.demo.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ActivityLogTest {
    private ActivityLog activityLog;

    @BeforeEach
    public void setUp() {
        activityLog = new ActivityLog();
    }

    @Test
    public void testGettersAndSetters() {
        Long id = 1L;
        LocalDateTime createdAt = LocalDateTime.now();
        String activityDescription = "Customer searched for products";
        String activityType = "SEARCH";
        String activity = "Search activity";
        Customer customer = new Customer();

        assertNull(activityLog.getId()); // The initial id should be null
        activityLog.setId(id);
        assertEquals(id, activityLog.getId());

        assertNull(activityLog.getCreatedAt());
        activityLog.setCreatedAt(createdAt);
        assertEquals(createdAt, activityLog.getCreatedAt());

        assertNull(activityLog.getActivityDescription());
        activityLog.setActivityDescription(activityDescription);
        assertEquals(activityDescription, activityLog.getActivityDescription());

        assertNull(activityLog.getActivityType());
        activityLog.setActivityType(activityType);
        assertEquals(activityType, activityLog.getActivityType());

        assertNull(activityLog.getActivity());
        activityLog.setActivity(activity);
        assertEquals(activity, activityLog.getActivity());

        assertNull(activityLog.getCustomer());
        activityLog.setCustomer(customer);
        assertEquals(customer, activityLog.getCustomer());
    }

    @Test
    public void testParameterizedConstructor() {
        Long id = 1L;
        LocalDateTime createdAt = LocalDateTime.now();
        String activityDescription = "Customer searched for products";
        String activityType = "SEARCH";
        String activity = "Search activity";
        Customer customer = new Customer();

        ActivityLog parameterizedActivityLog = new ActivityLog(id, createdAt, activityDescription, activityType, activity, customer);

        assertEquals(id, parameterizedActivityLog.getId());
        assertEquals(createdAt, parameterizedActivityLog.getCreatedAt());
        assertEquals(activityDescription, parameterizedActivityLog.getActivityDescription());
        assertEquals(activityType, parameterizedActivityLog.getActivityType());
        assertEquals(activity, parameterizedActivityLog.getActivity());
        assertEquals(customer, parameterizedActivityLog.getCustomer());
    }
}

package com.test.demo.service;

import com.test.demo.entity.ActivityLog;
import com.test.demo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityLogService {
    List<ActivityLog> findByCustomer(Customer customer);

    ActivityLog save(ActivityLog activityLog);

    void deleteById(Long id);
    void logActivity(Customer customer, String activityType, String activityDescription);
}

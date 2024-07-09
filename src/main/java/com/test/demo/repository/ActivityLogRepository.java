package com.test.demo.repository;

import com.test.demo.entity.ActivityLog;
import com.test.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
    List<ActivityLog> findByCustomer(Customer customer);
}

package com.test.demo.controller;

import com.test.demo.entity.ActivityLog;
import com.test.demo.entity.Customer;
import com.test.demo.service.ActivityLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity-logs")
public class ActivityLogController {
    private final ActivityLogService activityLogService;

    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<ActivityLog>> getActivityLogsByCustomer(@PathVariable("customerId") Long customerId) {
        Customer customer = new Customer();
        customer.setId(customerId);
        List<ActivityLog> activityLogs = activityLogService.findByCustomer(customer);
        return new ResponseEntity<>(activityLogs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActivityLog> createActivityLog(@RequestBody ActivityLog activityLog) {
        ActivityLog savedActivityLog = activityLogService.save(activityLog);
        return new ResponseEntity<>(savedActivityLog, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivityLog(@PathVariable("id") Long id) {
        activityLogService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

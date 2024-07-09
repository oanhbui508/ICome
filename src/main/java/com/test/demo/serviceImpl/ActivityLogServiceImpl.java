package com.test.demo.serviceImpl;

import com.test.demo.entity.ActivityLog;
import com.test.demo.entity.Customer;
import com.test.demo.repository.ActivityLogRepository;
import com.test.demo.service.ActivityLogService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @Override
    public List<ActivityLog> findByCustomer(Customer customer) {
        return activityLogRepository.findByCustomer(customer);
    }

    @Override
    public ActivityLog save(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

    @Override
    public void deleteById(Long id) {
        activityLogRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void logActivity(Customer customer, String activityType, String activityDescription) {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setCustomer(customer);
        activityLog.setActivityType(activityType);
        activityLog.setActivityDescription(activityDescription);
        activityLog.setCreatedAt(LocalDateTime.now());

        activityLogRepository.save(activityLog);
    }

}

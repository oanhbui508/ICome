package com.test.demo.dto;

public class ActivityLogDTO {
    private Long id;
    private Long customerId; // ID của khách hàng
    private String activity;
    private String activityType;
    private String activityDescription;

    // Constructors, getters, setters

    public ActivityLogDTO() {
    }

    public ActivityLogDTO(Long id, Long customerId, String activity, String activityType, String activityDescription) {
        this.id = id;
        this.customerId = customerId;
        this.activity = activity;
        this.activityType = activityType;
        this.activityDescription = activityDescription;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }
}

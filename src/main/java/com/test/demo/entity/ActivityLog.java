package com.test.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String activity;

    @Column(name = "activity_type")
    private String activityType;


    @Column(name = "activity_description")
    private String activityDescription;


    public String getActivityDescription() {
        return activityDescription;
    }

    public ActivityLog(Long id, LocalDateTime createdAt, String activityDescription, String activityType, String activity, Customer customer) {
        this.id = id;
        this.createdAt = createdAt;
        this.activityDescription = activityDescription;
        this.activityType = activityType;
        this.activity = activity;
        this.customer = customer;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public ActivityLog(Long id, LocalDateTime createdAt, String activityType, String activity, Customer customer) {
        this.id = id;
        this.createdAt = createdAt;
        this.activityType = activityType;
        this.activity = activity;
        this.customer = customer;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    private LocalDateTime createdAt = LocalDateTime.now();

    public ActivityLog() {
    }

    public ActivityLog(Long id, Customer customer, String activity, LocalDateTime createdAt) {
        this.id = id;
        this.customer = customer;
        this.activity = activity;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

package com.test.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.demo.entity.ActivityLog;
import com.test.demo.entity.Customer;
import com.test.demo.service.ActivityLogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ActivityLogControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ActivityLogService activityLogService;

    @InjectMocks
    private ActivityLogController activityLogController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(activityLogController).build();
    }

//    @Test
//    public void testGetActivityLogsByCustomer() throws Exception {
//        // Mock data
//        Long customerId = 1L;
//        Customer customer = new Customer();
//        customer.setId(customerId);
//        List<ActivityLog> activityLogs = Arrays.asList(
//                new ActivityLog(customer, "SEARCH", "Customer searched for products"),
//                new ActivityLog(customer, "VIEW", "Customer viewed product details")
//        );
//        when(activityLogService.findByCustomer(any(Customer.class))).thenReturn(activityLogs);
//
//        // Perform GET request and verify
//        mockMvc.perform(get("/activitylogs/customer/{customerId}", customerId))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect((ResultMatcher) jsonPath("$").isArray())
//                .andExpect((ResultMatcher) jsonPath("$.length()").value(activityLogs.size()));
//
//        // Verify that activityLogService.findByCustomer() was called once with the correct customerId
//        verify(activityLogService, times(1)).findByCustomer(any(Customer.class));
//    }
//
//    @Test
//    public void testCreateActivityLog() throws Exception {
//        // Mock data
//        ActivityLog activityLog = new ActivityLog(new Customer(), "SEARCH", "Customer searched for products");
//        ActivityLog savedActivityLog = new ActivityLog(activityLog.getCustomer(), activityLog.getActivityType(), activityLog.getActivityDescription());
//        savedActivityLog.setId(1L);
//        when(activityLogService.save(any(ActivityLog.class))).thenReturn(savedActivityLog);
//
//        // Perform POST request and verify
//        mockMvc.perform((RequestBuilder) post("/activitylogs")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .contentType(asJsonString(activityLog)))
//                .andExpect(status().isCreated())
//                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect((ResultMatcher) jsonPath("$.id").value(savedActivityLog.getId()))
//                .andExpect((ResultMatcher) jsonPath("$.customer").exists()) // Add assertions for other fields as needed
//
//                // Verify that activityLogService.save() was called once with the correct ActivityLog object
//                .andExpect((ResultMatcher) jsonPath("$.activityType").value(savedActivityLog.getActivityType()))
//                .andExpect((ResultMatcher) jsonPath("$.activityDescription").value(savedActivityLog.getActivityDescription()));
//        verify(activityLogService, times(1)).save(any(ActivityLog.class));
//    }

    @Test
    public void testDeleteActivityLog() throws Exception {
        // Mock data
        Long activityLogId = 1L;

        // Perform DELETE request and verify
        mockMvc.perform(delete("/activitylogs/{id}", activityLogId))
                .andExpect(status().isNoContent());

        // Verify that activityLogService.deleteById() was called once with the correct ID
        verify(activityLogService, times(1)).deleteById(activityLogId);
    }

    // Helper method to convert object to JSON string
    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package com.test.demo.serviceImplTest;
import com.test.demo.entity.ActivityLog;
import com.test.demo.entity.Customer;
import com.test.demo.repository.ActivityLogRepository;
import com.test.demo.serviceImpl.ActivityLogServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ActivityLogServiceImplTest {
    @Mock
    private ActivityLogRepository activityLogRepository;

    @InjectMocks
    private ActivityLogServiceImpl activityLogService;

    private Customer customer;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a sample customer
        customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        // Set other properties as needed

        // Mocking behavior of activityLogRepository.save()
        when(activityLogRepository.save(any(ActivityLog.class)))
                .thenAnswer(invocation -> {
                    ActivityLog activityLog = invocation.getArgument(0);
                    activityLog.setId(1L); // Simulate saving and setting ID
                    return activityLog;
                });
    }

    @Test
    public void testLogActivity() {
        // Call the method to log activities
        activityLogService.logActivity(customer, "SEARCH", "Customer searched for products");

        // Capture the argument passed to activityLogRepository.save()
        ArgumentCaptor<ActivityLog> argumentCaptor = ArgumentCaptor.forClass(ActivityLog.class);
        verify(activityLogRepository).save(argumentCaptor.capture());

        // Retrieve the captured ActivityLog object
        ActivityLog capturedActivityLog = argumentCaptor.getValue();

        // Assert the details of the saved ActivityLog
        assertEquals(customer, capturedActivityLog.getCustomer());
        assertEquals("SEARCH", capturedActivityLog.getActivityType());
        assertEquals("Customer searched for products", capturedActivityLog.getActivityDescription());
        // Optionally, you can assert other properties or behaviors as needed
    }
}

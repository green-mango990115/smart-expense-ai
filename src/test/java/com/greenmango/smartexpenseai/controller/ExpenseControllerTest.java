package com.greenmango.smartexpenseai.controller;

import com.greenmango.smartexpenseai.service.ExpenseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExpenseController.class)
public class ExpenseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Mock the service layer so we don't call the real DeepSeek API during testing
    @MockBean
    private ExpenseService expenseService;

    @Test
    public void testAskPolicyBot() throws Exception {
        // Arrange: Define the mock behavior for the AI service
        when(expenseService.getPolicyAnswer(anyString())).thenReturn("Mocked AI Answer for testing");

        String requestJson = "{\"question\": \"Can I book a flight?\"}";

        // Act & Assert: Perform POST request and expect specific JSON response
        mockMvc.perform(post("/api/expenses/chat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("SUCCESS"))
                .andExpect(jsonPath("$.answer").value("Mocked AI Answer for testing"));
    }
}
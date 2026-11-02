package com.greenmango.smartexpenseai.controller;

import com.greenmango.smartexpenseai.dto.ChatRequest;
import com.greenmango.smartexpenseai.dto.ChatResponse;
import com.greenmango.smartexpenseai.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    // Dependency injection using the interface
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    /**
     * Endpoint for the AI-powered policy assistant.
     *
     * @param request The chat request containing the user's question.
     * @return Standardized JSON response with the AI's answer.
     */
    @PostMapping("/chat")
    public ChatResponse askPolicyBot(@RequestBody ChatRequest request) {
        String answer = expenseService.getPolicyAnswer(request.getQuestion());
        return new ChatResponse(answer, "SUCCESS");
    }

    /**
     * Simulated endpoint for AI receipt extraction.
     *
     * @param imageUrl The URL of the uploaded receipt image.
     * @return Mocked JSON string representing the extracted expense data.
     */
    @PostMapping("/extract")
    public String extractReceipt(@RequestParam String imageUrl) {
        return "{\"merchant\": \"Lufthansa Airlines\", \"amount\": 450.00, \"category\": \"Travel\"}";
    }
}
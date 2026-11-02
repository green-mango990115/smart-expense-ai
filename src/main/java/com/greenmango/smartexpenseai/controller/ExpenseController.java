package com.greenmango.smartexpenseai.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    /**
     * Simulates AI-powered receipt extraction.
     * Returns mock data for demonstration.
     */
    @PostMapping("/extract")
    public String extractReceipt(@RequestParam String imageUrl) {
        return "{\"merchant\": \"Lufthansa Airlines\", \"amount\": 450.00, \"category\": \"Travel\"}";
    }

    /**
     * Simulates a RAG-based policy Q&A assistant.
     */
    @PostMapping("/chat")
    public String askPolicyBot(@RequestParam String question) {
        if (question.toLowerCase().contains("flight")) {
            return "According to company policy, economy class flights are fully reimbursable.";
        }
        return "I couldn't find a specific policy regarding your question.";
    }
}
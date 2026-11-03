package com.greenmango.smartexpenseai.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class ExpenseTools {

    // --- Tool 1: Currency Calculation ---
    public record CurrencyRequest(double amount, double exchangeRate) {}
    public record CurrencyResponse(double convertedAmount, String currency) {}

    @Tool(description = "Calculate the reimbursement amount by converting foreign currency to local currency (CNY) using the provided exchange rate.")
    public CurrencyResponse calculateReimbursement(CurrencyRequest request) {
        double total = request.amount() * request.exchangeRate();
        return new CurrencyResponse(total, "CNY");
    }

    // --- Tool 2: Check Expense Policy Limit ---
    public record LimitRequest(String category) {}
    public record LimitResponse(String category, double maxLimit, String currency) {}

    @Tool(description = "Get the maximum reimbursement limit for a specific expense category (e.g., Hotel, Meal, Flight).")
    public LimitResponse getExpenseLimit(LimitRequest request) {
        String cat = request.category().toLowerCase();
        if (cat.contains("hotel")) {
            return new LimitResponse("Hotel", 1500.00, "CNY");
        } else if (cat.contains("meal")) {
            return new LimitResponse("Meal", 300.00, "CNY");
        } else {
            return new LimitResponse("General", 5000.00, "CNY");
        }
    }

    // --- Tool 3: Check Approval Status ---
    public record StatusRequest(String expenseId) {}
    public record StatusResponse(String expenseId, String status, String approver) {}

    @Tool(description = "Check the current approval status of a specific expense report using its expense ID.")
    public StatusResponse checkApprovalStatus(StatusRequest request) {
        if ("EXP-1001".equals(request.expenseId())) {
            return new StatusResponse("EXP-1001", "APPROVED", "Manager Zhang");
        } else if ("EXP-1002".equals(request.expenseId())) {
            return new StatusResponse("EXP-1002", "PENDING", "Finance Department");
        } else {
            return new StatusResponse(request.expenseId(), "NOT_FOUND", "N/A");
        }
    }
}
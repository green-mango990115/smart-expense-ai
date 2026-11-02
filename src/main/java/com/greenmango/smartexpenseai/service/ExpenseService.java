package com.greenmango.smartexpenseai.service;

public interface ExpenseService {
    
    /**
     * Get AI-generated answer for travel and expense policy questions.
     *
     * @param question The user's natural language question.
     * @return The AI response.
     */
    String getPolicyAnswer(String question);
}
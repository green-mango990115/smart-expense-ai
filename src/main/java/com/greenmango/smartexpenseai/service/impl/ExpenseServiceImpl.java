package com.greenmango.smartexpenseai.service.impl;

import com.greenmango.smartexpenseai.exception.AiServiceException;
import com.greenmango.smartexpenseai.service.ExpenseService;
import com.greenmango.smartexpenseai.tools.ExpenseTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ChatClient chatClient;

    // Dynamically register all tools from the ExpenseTools component
    public ExpenseServiceImpl(ChatClient.Builder chatClientBuilder, ExpenseTools expenseTools) {
        this.chatClient = chatClientBuilder
                .defaultTools(expenseTools)
                .build();
    }

    @Override
    public String getPolicyAnswer(String question) {
        String systemPrompt = """
                You are an AI assistant for corporate Travel and Expense (T&E) management.
                Answer the user's questions based on standard corporate policies.
                You have access to tools to calculate currency, check limits, and check approval status. Use them when necessary.
                Keep your answers concise, professional, and helpful.
                """;

        try {
            return chatClient.prompt()
                    .system(systemPrompt)
                    .user(question)
                    .call()
                    .content();
        } catch (Exception e) {
            throw new AiServiceException("Failed to get response from AI model: " + e.getMessage());
        }
    }
}
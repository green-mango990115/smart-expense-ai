package com.greenmango.smartexpenseai.service.impl;

import com.greenmango.smartexpenseai.exception.AiServiceException;
import com.greenmango.smartexpenseai.service.ExpenseService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ChatClient chatClient;

    public ExpenseServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public String getPolicyAnswer(String question) {
        String systemPrompt = """
                You are an AI assistant for corporate Travel and Expense (T&E) management.
                Answer the user's questions based on standard corporate policies.
                If the user asks about flights, mention that economy class is fully reimbursable.
                Keep your answers concise, professional, and helpful.
                """;

        try {
            return chatClient.prompt()
                    .system(systemPrompt)
                    .user(question)
                    .call()
                    .content();
        } catch (Exception e) {
            // Throw custom exception to be caught by GlobalExceptionHandler
            throw new AiServiceException("Failed to get response from AI model: " + e.getMessage());
        }
    }
}
package com.greenmango.smartexpenseai.exception;

import com.greenmango.smartexpenseai.dto.ChatResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle custom AI service exceptions.
     */
    @ExceptionHandler(AiServiceException.class)
    public ResponseEntity<ChatResponse> handleAiServiceException(AiServiceException ex) {
        ChatResponse response = new ChatResponse(ex.getMessage(), "AI_SERVICE_ERROR");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handle all other unhandled exceptions (fallback).
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ChatResponse> handleGlobalException(Exception ex) {
        ChatResponse response = new ChatResponse("An unexpected error occurred: " + ex.getMessage(), "INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
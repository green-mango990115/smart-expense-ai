package com.greenmango.smartexpenseai.exception;

/**
 * Custom exception for handling AI service related errors.
 */
public class AiServiceException extends RuntimeException {
    public AiServiceException(String message) {
        super(message);
    }
}
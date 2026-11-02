package com.greenmango.smartexpenseai.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatResponse {
    private String answer;
    private String status;
}
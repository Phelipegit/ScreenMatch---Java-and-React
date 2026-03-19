package com.phelipe.ScreenMatch.dto.response;

import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class ErrorResponse {
    private boolean success;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(boolean success, String message, LocalDateTime timestamp) {
        this.success = success;
        this.message = message;
        this.timestamp = timestamp;
    }
}

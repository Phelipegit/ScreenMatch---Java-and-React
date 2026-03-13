package com.phelipe.ScreenMatch.dto.response;

import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class ErrorResponse {
    private final boolean success;
    private final String message;
    private final Map<String, String> errors;
    private final LocalDateTime timestamp;

    public ErrorResponse(boolean success, String message,
                         Map<String, String> errors, LocalDateTime timestamp) {
        this.success = success;
        this.message = message;
        this.errors = errors;
        this.timestamp = timestamp;
    }
}

package com.phelipe.ScreenMatch.Exception;

import com.phelipe.ScreenMatch.Exception.ExceptionUser.ScreenMatchException;
import com.phelipe.ScreenMatch.dto.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validationError(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        ErrorResponse response = new ErrorResponse(
                false, "Validação falhou!", errors, LocalDateTime.now()
        );
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ScreenMatchException.class)
    public ResponseEntity<ErrorResponse> businessError(ScreenMatchException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("code", ex.getCode());
        ErrorResponse response = new ErrorResponse(
                false, ex.getMessage(), errors, LocalDateTime.now()
        );
        return ResponseEntity.status(422).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericError(Exception ex) {
        Map<String, String> errors = Map.of("error", "Erro interno do servidor");
        ErrorResponse response = new ErrorResponse(
                false, "Erro interno!", errors, LocalDateTime.now()
        );
        return ResponseEntity.internalServerError().body(response);
    }
}

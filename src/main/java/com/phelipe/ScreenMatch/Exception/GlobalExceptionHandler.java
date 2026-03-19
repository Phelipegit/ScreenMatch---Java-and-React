package com.phelipe.ScreenMatch.Exception;

import com.phelipe.ScreenMatch.Exception.ExceptionUser.ScreenMatchException;
import com.phelipe.ScreenMatch.dto.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Validação de campos (@NotBlank, @Min, @Max, @Size, etc.)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validationError(MethodArgumentNotValidException ex) {
        // pega a primeira mensagem de erro como message
        String message = "Houve erro de validação.";
        Map<String, String> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .collect(
                        java.util.stream.Collectors.toMap(
                                e -> e.getField(),
                                e -> e.getDefaultMessage()
                        )
                );

        if (!fieldErrors.isEmpty()) {
            message = fieldErrors.values().iterator().next();
        }

        ErrorResponse response = new ErrorResponse(false, message, LocalDateTime.now());
        return ResponseEntity.badRequest().body(response);
    }

    // 2. Erros de negócio (ScreenMatchException)
    @ExceptionHandler(ScreenMatchException.class)
    public ResponseEntity<ErrorResponse> businessError(ScreenMatchException ex) {
        ErrorResponse response = new ErrorResponse(false, ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(422).body(response);
    }

    // 3. Erro genérico
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> genericError(Exception ex) {
        ErrorResponse response = new ErrorResponse(false, "Erro interno!", LocalDateTime.now());
        return ResponseEntity.internalServerError().body(response);
    }
}

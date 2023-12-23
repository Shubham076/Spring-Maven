package com.example.practise;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


// It tells Spring that you are interested in any exceptions that might be thrown.
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAllExceptions(Exception ex) {
        // Log the exception details for debugging
        ex.printStackTrace();

        // Create a response with an error key
        Map<String, String> errorResponse = Collections.singletonMap("error", ex.getMessage());
        return ResponseEntity.internalServerError().body(errorResponse);
    }

//    The @ExceptionHandler annotation tells spring "Whenever this specific kind of problem (exception) happens, I want you to use this particular method (the one with the annotation) to handle it."
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                //(FieldError error) -> error.getDefaultMessage(), shorthand use method reference below
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }
}

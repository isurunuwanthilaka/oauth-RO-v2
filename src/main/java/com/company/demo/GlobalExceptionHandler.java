package com.company.demo;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity handleFeignStatusException(FeignException e) {
        return ResponseEntity.status(e.status()).body(e.contentUTF8());
    }
}

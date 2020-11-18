package com.company.demo;

import com.company.demo.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final AuthService authService;

    @GetMapping("/resource-secondary/hello")
    public ResponseEntity hello() {
        Boolean isValid = authService.validateJwt("");

        if (isValid) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}

package com.company.demo;

import com.company.demo.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class Controller {
    private final AuthService authService;

    @GetMapping("/hello")
    public ResponseEntity hello(HttpServletRequest request) {

        String jwt = authService.getJwtFromRequest(request);

        if (jwt == null) {
            return ResponseEntity.badRequest().build();
        }

        Boolean isValid = authService.validateJwt(jwt);

        if (isValid) {
            return ResponseEntity.ok("Success");
        }

        return ResponseEntity.badRequest().build();
    }
}

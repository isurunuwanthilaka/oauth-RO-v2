package com.company.demo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthServiceClient authServiceClient;

    public Boolean validateJwt(String jwt) {
        ResponseEntity responseEntity = authServiceClient.validateJwt(String.format("Bearer %s", jwt));

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return true;
        } else {
            return false;
        }
    }
}

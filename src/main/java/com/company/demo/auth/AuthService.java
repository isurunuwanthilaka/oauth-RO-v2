package com.company.demo.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

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

    public String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}

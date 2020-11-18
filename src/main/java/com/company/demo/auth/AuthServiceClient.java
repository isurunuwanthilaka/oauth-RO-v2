package com.company.demo.auth;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "auth", url = "${auth.url}")
public interface AuthServiceClient {

    String AUTHORIZATION = "Authorization";

    @PostMapping("/auth/v1/jwt/validate")
    @Headers("Content-Type: application/json")
    ResponseEntity validateJwt(@RequestHeader(AUTHORIZATION) String bearerToken);
}

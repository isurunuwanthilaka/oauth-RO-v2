package com.company.demo.auth;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "auth", url = "${auth.url}")
public interface Auth {
}

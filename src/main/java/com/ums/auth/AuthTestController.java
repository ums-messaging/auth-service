package com.ums.auth;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class AuthTestController {
    TestProperties properties;

    public AuthTestController(TestProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/ping")
    public String ping() {
        return "auth-service pong";
    }

    @GetMapping("/health")
    public String health() {
        return "auth-service is healthy";
    }

    @GetMapping("/config/bus")
    public String configure() {
        return properties.toString();
    }
}
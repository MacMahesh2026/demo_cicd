package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@RestController
public class WelcomeController {

    @GetMapping("/api/welcome")
    public Map<String, String> sayHello() {
        return Map.of(
                "status", "success",
                "message", "Hello Mahesh! Your Spring Boot server is officially running."
        );
    }

    @GetMapping("/api/greet")
    public Map<String, String> greetUser(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return Map.of(
                "message", "Welcome to Java development, " + name + "!"
        );
    }



    @PostMapping("/api/projects")
    public Map<String, Object> createProject(@RequestBody ProjectPayload payload) {
        return Map.of(
                "received", true,
                "migratingFrom", payload.framework(),
                "newProjectTitle", payload.title(),
                "status", "Java parsed this JSON automatically!"
        );
    }


}

// A simple DTO Record - matches a structured PHP DTO
record ProjectPayload(String title, String framework) {}

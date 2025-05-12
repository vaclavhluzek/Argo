// filepath: /Users/vaclavhluzek/Library/CloudStorage/OneDrive-Sdílenéknihovny–Onedrive-Seyfor/Seyfor/customers/Creditas/POC/Argo/app/src/main/java/com/example/backend/controller/HelloController.java
package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot Backend!";
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
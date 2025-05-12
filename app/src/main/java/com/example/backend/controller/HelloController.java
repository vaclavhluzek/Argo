// filepath: /Users/vaclavhluzek/Library/CloudStorage/OneDrive-Sdílenéknihovny–Onedrive-Seyfor/Seyfor/customers/Creditas/POC/Argo/app/src/main/java/com/example/backend/controller/HelloController.java
package com.example.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
    
    @GetMapping("/podinfo")
    public String podInfo() {
        StringBuilder info = new StringBuilder();
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            
            info.append("Pod Name: ").append(hostname).append("\n");
            info.append("Pod IP: ").append(ipAddress).append("\n");
            
            // Add environment-based hostname if available (Kubernetes sets this)
            String k8sHostname = System.getenv("HOSTNAME");
            if (k8sHostname != null && !k8sHostname.isEmpty()) {
                info.append("Kubernetes Hostname: ").append(k8sHostname).append("\n");
            }
            
            // Add namespace information if available
            String namespace = System.getenv("POD_NAMESPACE");
            if (namespace != null && !namespace.isEmpty()) {
                info.append("Namespace: ").append(namespace).append("\n");
            }
        } catch (UnknownHostException e) {
            info.append("Error retrieving host information: ").append(e.getMessage());
        }
        return info.toString();
    }
}
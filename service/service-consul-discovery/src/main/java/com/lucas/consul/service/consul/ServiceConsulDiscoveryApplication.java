package com.lucas.consul.service.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceConsulDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsulDiscoveryApplication.class, args);
    }

}

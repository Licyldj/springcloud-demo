package com.lucas.provider.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderServiceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderServiceDemoApplication.class, args);
    }

}

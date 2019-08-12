package com.lucas.gateway2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GatewayZuul2xApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuul2xApplication.class, args);
    }

}

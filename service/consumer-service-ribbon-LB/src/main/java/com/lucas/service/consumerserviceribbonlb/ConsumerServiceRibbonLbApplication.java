package com.lucas.service.consumerserviceribbonlb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class ConsumerServiceRibbonLbApplication {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceRibbonLbApplication.class, args);
    }

    @RequestMapping(value = "/student/{studentid}", method = RequestMethod.GET)
    public String findStudentInfo(@PathVariable Long studentid) {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider-service");
        System.out.println("serviceId:" + serviceInstance.getServiceId() + "  host:" + serviceInstance.getHost() + "  port:" + serviceInstance.getPort());

//        log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());

        return this.restTemplate.getForObject("http://provider-service/hello", String.class);
    }


}

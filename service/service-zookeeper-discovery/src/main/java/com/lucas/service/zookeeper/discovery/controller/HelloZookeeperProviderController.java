package com.lucas.service.zookeeper.discovery.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

/**
 * @author LucasLee
 * @data ${data} ${time}
 */
@Log
@RestController
public class HelloZookeeperProviderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/hello")
    public String helloZookeeperProvider() {
        List<ServiceInstance> instances = discoveryClient.getInstances("service-zookeeper-discovery");

        ServiceInstance serviceInstance = instances.get(0);

        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        URI uri = serviceInstance.getUri();

        String result = "success";
        log.info("/hello, host:" + host + ", port:" + port + ", URI:" + uri);

        return result;
    }
}

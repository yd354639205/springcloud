package com.cloud.producercopy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ProducerCopyApplication {
    @Value("${hello}")
    private String hello;

    public static void main(String[] args) {
        SpringApplication.run(ProducerCopyApplication.class, args);
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return name + ", " + hello;
    }
}

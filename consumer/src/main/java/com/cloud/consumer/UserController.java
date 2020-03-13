package com.cloud.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    private final RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("test")
    public String test() {
        return restTemplate.getForObject("http://SPRING-CLOUD-PRODUCER/hello/user", String.class);
    }
}

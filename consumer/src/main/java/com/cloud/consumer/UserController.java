package com.cloud.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "defaultTest")
    @GetMapping("test")
    public String test() {
        log.info("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        return restTemplate.getForObject("http://SPRING-CLOUD-PRODUCER/hello/user", String.class);
    }


    public String defaultTest() {
        return "This is an error message";
    }
}

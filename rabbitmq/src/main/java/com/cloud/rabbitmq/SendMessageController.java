package com.cloud.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        String message = "direct message, hello!";
        rabbitTemplate.convertAndSend("DirectExchange", "DirectRouting", message);
        return "ok";
    }

    @GetMapping("/sendTopicManMessage")
    public String sendTopicManMessage() {
        String message = "topic.man message, hello!";
        rabbitTemplate.convertAndSend("TopicExchange", "topic.man", message);
        return "ok";
    }

    @GetMapping("/sendTopicTestMessage")
    public String sendTopicTestMessage() {
        String message = "topic.123 message, hello!";
        rabbitTemplate.convertAndSend("TopicExchange", "topic.test", message);
        return "ok";
    }

    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage() {
        String message = "fanout message, hello!";
        rabbitTemplate.convertAndSend("FanoutExchange", null, message);
        return "ok";
    }
}

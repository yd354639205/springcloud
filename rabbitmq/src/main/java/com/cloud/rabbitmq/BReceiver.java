package com.cloud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = FanoutRabbitConfig.B)
public class BReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("BReceiver接收到的消息是:" + msg);
    }
}

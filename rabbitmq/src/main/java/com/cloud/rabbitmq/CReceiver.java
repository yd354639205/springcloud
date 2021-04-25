package com.cloud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = FanoutRabbitConfig.C)
public class CReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("CReceiver接收到的消息是:" + msg);
    }
}

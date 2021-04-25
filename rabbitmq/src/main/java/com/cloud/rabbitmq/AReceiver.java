package com.cloud.rabbitmq;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = FanoutRabbitConfig.A)
public class AReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("AReceiver接收到的消息是:" + msg);
    }
}

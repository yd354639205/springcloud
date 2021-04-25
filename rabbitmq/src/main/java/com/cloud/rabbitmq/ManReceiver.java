package com.cloud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = TopicRabbitConfig.MAN)
public class ManReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("ManReceiver接收到的消息是:" + msg);
    }
}

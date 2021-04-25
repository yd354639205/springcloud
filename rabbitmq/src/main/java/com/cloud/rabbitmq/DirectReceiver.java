package com.cloud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "DirectQueue")
public class DirectReceiver {

    @RabbitHandler
    public void process(String msg) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("DirectReceiver接收到的消息是:" + msg);
    }
}

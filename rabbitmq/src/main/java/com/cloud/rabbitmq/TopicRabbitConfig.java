package com.cloud.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitConfig {
    public static final String MAN = "topic.man";
    public static final String WOMAN = "topic.woman";

    @Bean
    public Queue TopicManQueue() {
        return new Queue(MAN, true);
    }

    @Bean
    public Queue TopicWomanQueue() {
        return new Queue(WOMAN, true);
    }

    @Bean
    TopicExchange TopicExchange() {
        return new TopicExchange("TopicExchange", true, false);
    }

    @Bean
    Binding bindingTopicMan() {
        return BindingBuilder.bind(TopicManQueue()).to(TopicExchange()).with(MAN);
    }

    @Bean
    Binding bindingTopic() {
        return BindingBuilder.bind(TopicWomanQueue()).to(TopicExchange()).with("topic.#");
    }
}

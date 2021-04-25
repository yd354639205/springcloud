package com.cloud.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FanoutRabbitConfig {
    public static final String A = "fanout.a";
    public static final String B = "fanout.b";
    public static final String C = "fanout.c";

    @Bean
    public Queue A() {
        return new Queue(A, true);
    }

    @Bean
    public Queue B() {
        return new Queue(B, true);
    }

    @Bean
    public Queue C() { return new Queue(C, true); }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("FanoutExchange", true, false);
    }

    @Bean
    Binding bindingA() {
        return BindingBuilder.bind(A()).to(fanoutExchange());
    }

    @Bean
    Binding bindingB() { return BindingBuilder.bind(B()).to(fanoutExchange()); }

    @Bean
    Binding bindingC() { return BindingBuilder.bind(C()).to(fanoutExchange()); }
}

package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 是一种点对点，实现发布/订阅标准的交换器。
 * Producer发送消息到RabbitMQ中，MQ中的Direct交换器接受到消息后，会根据Routing Key来决定这个消息要发送到哪一个队列中。
 * Consumer则负责注册一个队列监听器，来监听队列的状态，当队列状态发生变化时，消费消息。注册队列监听需要提供交换器信息，队列信息和路由键信息。
 * 这种交换器通常用于点对点消息传输的业务模型中。如电子邮箱。
 */
@SpringBootApplication
public class AmqpServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AmqpServerApplication.class,args);
    }
}

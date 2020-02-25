package org.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主题交换器，也称为规则匹配交换器。是通过自定义的模糊匹配规则来决定消息存储在哪些队列中。
 * 当Producer发送消息到RabbitMQ中时，MQ中的交换器会根据路由键来决定消息应该发送到哪些队列中。
 * Consumer同样是注册一个监听器到队列，监听队列状态，当队列状态发生变化时，消费消息。
 * 注册监听器需要提供交换器信息，队列信息和路由键信息。
 */
@SpringBootApplication
public class TopicServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TopicServerApplication.class,args);

    }

}

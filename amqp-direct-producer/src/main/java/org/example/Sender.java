package org.example;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    //exchange 交换器名称
    @Value("${mq.config.exchange}")
    private String exchange;

    //routingkey 路由键
    @Value("${mq.config.queue.info.routing.key}")
    private String info_routing_key;

    @Value("${mq.config.queue.error.routing.key}")
    private String error_routing_key;

    public void info_send(LogMessage msg){
        /**
         * convertAndSend - 转换并发送消息的template方法。
         * 是将传入的普通java对象，转换为rabbitmq中需要的message类型对象，并发送消息到rabbitmq中。
         * 参数一：交换器名称。 类型是String
         * 参数二：路由键。 类型是String
         * 参数三：消息，是要发送的消息内容对象。类型是Object
         */
        this.amqpTemplate.convertAndSend(this.exchange,this.info_routing_key,msg);
    }

    public void error_send(LogMessage msg){
        /**
         * convertAndSend - 转换并发送消息的template方法。
         * 是将传入的普通java对象，转换为rabbitmq中需要的message类型对象，并发送消息到rabbitmq中。
         * 参数一：交换器名称。 类型是String
         * 参数二：路由键。 类型是String
         * 参数三：消息，是要发送的消息内容对象。类型是Object
         */
        this.amqpTemplate.convertAndSend(this.exchange,this.error_routing_key,msg);
    }
}

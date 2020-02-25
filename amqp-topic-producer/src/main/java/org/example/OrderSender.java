package org.example;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    public void send(String msg){
        //向消息队列发送消息
        //参数一：交换器名称。
        //参数二：路由键
        //参数三：消息
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.debug","order.log.debug..."+msg);
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.info","order.log.info..."+msg);
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.warn","order.log.warn..."+msg);
        this.amqpTemplate.convertAndSend(this.exchange,"order.log.error","order.log.error..."+msg);
    }
}

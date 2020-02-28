package org.example;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 和direct交换器的区别是： Exchange的类型为TOPIC。
 * 全日志处理。
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.logs}",autoDelete = "false"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
                key="user.log.*"
        )
)
public class LogsReceiver {
    @RabbitHandler
    public void process(String msg){
        System.out.println("=======user logs=========");
        System.out.println(msg);
    }
    public void start() throws InterruptedException {
        while (true)
        {
            Thread.sleep(1000);
        }
    }
}

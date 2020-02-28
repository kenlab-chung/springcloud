package org.example;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class MultiReceiver {
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "${mq.config.queue.warn}",autoDelete = "false"),
                    exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
                    key="*.log.warn"
            )
    )
    public void processInfo(String msg){
        System.out.println("=======warn=========");
        System.out.println(msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "${mq.config.queue.error}",autoDelete = "false"),
                    exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
                    key="*.log.error"
            )
    )
    public void processError(String msg){
        System.out.println("=======error=========");
        System.out.println(msg);
    }
    public void start() throws InterruptedException {
        while (true)
        {
            Thread.sleep(1000);
        }
    }
}

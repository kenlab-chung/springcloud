package org.example;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.push}",autoDelete = "false"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.FANOUT,autoDelete = "false")
        )
)
public class PushReceiver {
    @RabbitHandler
    public void process(String msg){
        System.out.println("Push receiver:"+msg);
    }
    public void start() throws InterruptedException {
        while (true)
        {
            Thread.sleep(1000);
        }
    }
}

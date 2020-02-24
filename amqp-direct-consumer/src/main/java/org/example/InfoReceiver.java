package org.example;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${mq.config.queue.info}",autoDelete="false"),
        exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),
        key = "${mq.config.queue.info.routing.key}"
))
public class InfoReceiver {
    @RabbitHandler
    public void process(LogMessage msg)
    {
        System.out.println("info============>>>>>>>receiver===========>>>>>>>");
        System.out.println(msg.toString());
    }
    public void start() throws InterruptedException{
        while (true)
        {
            Thread.sleep(1000);
        }
    }
}

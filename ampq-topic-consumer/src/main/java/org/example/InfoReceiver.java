package org.example;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.info}",autoDelete = "false"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
                key="user.log.info"
        )
)
public class InfoReceiver {
        @RabbitHandler
        public  void process(String msg){
                System.out.println("======= user info ========");
                System.out.println(msg);
        }
        public void start() throws InterruptedException {
                while (true)
                {
                        Thread.sleep(1000);
                }
        }
}

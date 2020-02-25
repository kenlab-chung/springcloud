package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 广播交换器。这种交换器会将接收到的消息发送给绑定的所有队列中。当Producer发送消息到RabbitMQ时，
 * 交换器会将消息发送到已绑定的所有队列中，这个过程交换器不会尝试匹配路由键，
 * 所以消息中不需要提供路由键信息。Consumer仍旧注册监听器到队列，监听队列状态，当队列状态发生变化，
 * 消费消息。注册监听器需要提供交换器信息和队列信息。
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FanoutServerApplication.class)
public class FanoutServerApplicationTests {
    @Autowired
    private Sender sender;

    @Test
    public void test() throws InterruptedException {
        while (true){
            Thread.sleep(1000);
            this.sender.send("fanout messages");
        }
    }
}

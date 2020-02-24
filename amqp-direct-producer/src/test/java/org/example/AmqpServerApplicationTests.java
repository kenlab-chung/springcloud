package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
/**
 * Direct交换器
 * Producer测试。
 * 注意：
 * 在rabbitmq中，consumer都是listener监听模式消费消息的。
 * 一般来说，在开发的时候，都是先启动consumer，确定有什么exchange、queue、routing-key，然后再启动producer。
 * 然后再启动producer发送消息，。
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AmqpServerApplication.class)
public class AmqpServerApplicationTests {
    @Autowired
    private Sender sender;
    @Test
    public void  testSend() throws Exception
    {
        long id = 1l;
        while (true)
        {
            Thread.sleep(1000);
            LogMessage msg = new LogMessage(id,"test log","info","order service",new Date(),id);
            System.out.println(msg.toString());
            this.sender.info_send(msg);
           // Thread.sleep(1000);
            msg.setLogLevel("error");
            System.out.println(msg.toString());
            this.sender.error_send(msg);
        }
    }
}

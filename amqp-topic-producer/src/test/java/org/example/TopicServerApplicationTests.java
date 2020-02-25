package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TopicServerApplication.class)
public class TopicServerApplicationTests {
    @Autowired
    private UserSender userSender;

    @Autowired
    private OrderSender orderSender;

    @Test
    public void test() throws InterruptedException {
        while (true)
        {
            Thread.sleep(1000);
            this.userSender.send("UserSender......");
            this.orderSender.send("OrderSender.....");
        }
    }
}

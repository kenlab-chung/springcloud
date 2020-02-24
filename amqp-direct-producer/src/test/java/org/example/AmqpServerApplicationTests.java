package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

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
            msg.setLogLevel("error");
            System.out.println(msg.toString());
            this.sender.info_send(msg);
        }
    }
}

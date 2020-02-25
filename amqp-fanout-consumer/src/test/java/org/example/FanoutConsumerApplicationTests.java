package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FanoutConsumerApplication.class)
public class FanoutConsumerApplicationTests {
    @Autowired
    private PushReceiver pushReceiver;
    @Autowired
    private SmsReceiver smsReceiver;

    @Test
    public void Test() throws InterruptedException {
        Thread push = new Thread(pushRun);
        push.start();

        Thread sms = new Thread(SmsRun);
        sms.start();

        push.join();
        sms.join();
    }

    private Runnable pushRun = new Runnable() {
        @Override
        public void run() {
            try{
                pushReceiver.start();
            }
            catch (Exception ex)
            {}

        }
    };

    private Runnable SmsRun = new Runnable() {
        @Override
        public void run() {
            try{
                smsReceiver.start();
            }
            catch (Exception ex)
            {}

        }
    };
}

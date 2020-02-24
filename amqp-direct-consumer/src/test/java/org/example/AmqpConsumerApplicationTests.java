package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AmqpConsumerApplication.class)
public class AmqpConsumerApplicationTests {
    @Autowired
    private ErrorReceiver errorReceiver;
    @Autowired
    private InfoReceiver infoReceiver;

    @Test
    public void testReceiver() {
       Thread error = new Thread(errorRun);
       error.start();

        Thread info = new Thread(infoRun);
        info.start();

        try {
            error.join();
            info.join();
        }
        catch (InterruptedException ex)
        {}

    }

    private Runnable infoRun = new Runnable() {
        @Override
        public void run() {
            try{
                infoReceiver.start();
            }
            catch (Exception ex)
            {}

        }
    };
    private Runnable errorRun = new Runnable() {
        @Override
        public void run() {
            try{
                errorReceiver.start();
            }
            catch (Exception ex)
            {}

        }
    };
}

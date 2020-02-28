package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TopicConsumerApplication.class)
public class TopicConsumerApplicationTests {

    @Autowired
    private InfoReceiver infoReceiver;

    @Autowired
    private LogsReceiver logsReceiver;

    @Autowired
    private MultiReceiver multiReceiver;

    @Test
    public void Test() throws InterruptedException {
        Thread multi = new Thread(multiRun);
        multi.start();
//        Thread info = new Thread(infoRun);
//        info.start();
//
//        Thread log = new Thread(logRun);
//        log.start();
//
//        info.join();
//        log.join();
        multi.join();
    }
    private Runnable multiRun = new Runnable() {
        @Override
        public void run() {
            try{
                multiReceiver.start();
            }
            catch (Exception ex)
            {}

        }
    };

    private Runnable infoRun = new Runnable() {
        @Override
        public void run() {
            try{
                //infoReceiver.start();
            }
            catch (Exception ex)
            {}

        }
    };

    private Runnable logRun = new Runnable() {
        @Override
        public void run() {
            try{
              //  logsReceiver.start();
            }
            catch (Exception ex)
            {}

        }
    };
}

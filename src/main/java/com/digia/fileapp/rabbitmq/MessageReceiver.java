package com.digia.fileapp.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {
    private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        log.info("Received {}", message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
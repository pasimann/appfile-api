package com.digia.fileapp.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.digia.fileapp.store.FileAppStore;

@Component
public class FileAppTaskScheduler {

    private static final Logger log = LoggerFactory.getLogger(FileAppTaskScheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    FileAppStore store; 

    @Scheduled(fixedRate = 10000)
    public void consumeItemFromStore() {
        log.info("The time is now {}", dateFormat.format(new Date()));
        String value = store.popItemFromStoreQueue();

        if (value != null) {
            log.info("Read from the store {}", value);
        } else {
            log.info("The store is empty!");
        }
    }

}
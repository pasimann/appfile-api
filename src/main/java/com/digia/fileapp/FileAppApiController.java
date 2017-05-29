package com.digia.fileapp;

import java.lang.Integer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.digia.fileapp.rabbitmq.MessageSender;

@Controller
public class FileAppApiController {

    private static final Logger log = LoggerFactory.getLogger(FileAppApiController.class);

    @Autowired
    MessageSender sender; 

    @RequestMapping(value={"/send-to-store"}, method=RequestMethod.POST)
    public @ResponseBody Integer sendDataToStore(
        @RequestBody String data) {

        log.info("Got data {}", data); 
        sender.sendMessage(data);

        return 0; 
    }
}

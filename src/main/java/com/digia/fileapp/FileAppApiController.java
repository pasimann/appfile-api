package com.digia.fileapp;

import java.util.List;
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

import com.digia.fileapp.store.FileAppStore;

@Controller
public class FileAppApiController {

    private static final Logger log = LoggerFactory.getLogger(FileAppApiController.class);

    @Autowired
    FileAppStore store; 

    @RequestMapping(value={"/get-items-from-store"}, method=RequestMethod.GET)
    public @ResponseBody List<String> getItemsFromFileStore(
            @RequestParam(value="search", required=false) String search) {

        List<String> result = store.getItemsFromStoreQueue();
        
        return result;
    }

    @RequestMapping(value={"/put-item-to-store"}, method=RequestMethod.POST)
    public @ResponseBody Integer putItemToFileStore(
        @RequestBody String data) {

        log.info("Got data {}", data); 

        store.putItemToStoreQueue(data);
        return 0; 
    }
}

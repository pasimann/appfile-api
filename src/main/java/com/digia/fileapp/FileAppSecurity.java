package com.digia.fileapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

@Component("fileAppSecurity")
public class FileAppSecurity {
    private static final Logger log = LoggerFactory.getLogger(FileAppSecurity.class);

    public FileAppSecurity() { }

    public void init() {
        log.info("FileAppSecurity init()");
    }

    public boolean hasPermission(Authentication authentication) {
        log.info("Got auth {}", authentication.toString());

        return true;
    }
}
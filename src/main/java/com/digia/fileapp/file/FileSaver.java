package com.digia.fileapp.file;

import java.util.UUID; 
import java.util.ResourceBundle;
import java.nio.file.Files; 
import java.lang.StringBuilder; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSaver {
    private static final Logger log = LoggerFactory.getLogger(FileSaver.class);

    private static final String PROPERTIES_FILENAME = "APPFILEAPI";

    private static ResourceBundle propertiesBundle;

    static {
       propertiesBundle = ResourceBundle.getBundle(PROPERTIES_FILENAME);
    }

    public static SaveFileFromData(byte[] data, String extension) {
        
        String folderName = propertiesBundle.getString("fileapi.datafolder");

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        StringBuilder target = new StringBuilder(); 
        target.append(folderName); 
        target.append("/"); 
        target.append(String.format("%s.%s", randomUUIDString, extension));

        log.info("Writing to file {}", target.toString()); 
        
        Path file = Paths.get(target.toString());
        Files.write(file, data);
       
    }
}
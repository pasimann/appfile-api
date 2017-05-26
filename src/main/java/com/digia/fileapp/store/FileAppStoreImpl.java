package com.digia.fileapp.store;

import java.util.List; 
import java.util.ArrayList; 

import org.springframework.stereotype.Service;

@Service
public class FileAppStoreImpl implements FileAppStore {
    private List<String> store = new ArrayList<>(); 

    // TODO make store singleton
    // TODO store array must be concurrent; thread safe version 
    
    public FileAppStoreImpl() { }

    @Override
    public void putItemToStoreQueue(String item) {
        store.add(item); 
    }

    @Override
    public String popItemFromStoreQueue() {
        String result = store.get(0);
        store.remove(0);
        return result;
    }

    @Override
    public List<String> getItemsFromStoreQueue() {
        return store; 
    }
}
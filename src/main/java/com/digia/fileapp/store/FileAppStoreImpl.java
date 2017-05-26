package com.digia.fileapp.store;

import java.util.List; 
import java.util.ArrayList; 
import java.util.Collections;

import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Scope; 

@Service
@Scope("singleton")
public class FileAppStoreImpl implements FileAppStore {
    
    private List<String> store = Collections.synchronizedList(new ArrayList<>());

    public FileAppStoreImpl() { }

    @Override
    public void putItemToStoreQueue(String item) {
        store.add(item); 
    }

    @Override
    public String popItemFromStoreQueue() {
        if (store.size() > 0) {
          String result = store.get(0);
          store.remove(0);
          return result;
        }
        return null;
    }

    @Override
    public List<String> getItemsFromStoreQueue() {
        return store; 
    }
}
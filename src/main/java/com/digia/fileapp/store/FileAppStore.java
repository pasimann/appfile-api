package com.digia.fileapp.store; 

import java.util.List; 

public interface FileAppStore {
    public void putItemToStoreQueue(String item); 
    public String popItemFromStoreQueue(); 
    public List<String> getItemsFromStoreQueue(); 
}
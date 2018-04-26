package com.digia.fileapp.store;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileAppStoreImplTest {

    @Autowired
    FileAppStoreImpl store;

    public FileAppStoreImplTest() { }

    @Test
    public void testPutItemToStoreQueue() {

        List<String> items = List.of("foo", "bar", "baz");
        items.forEach(item -> store.putItemToStoreQueue(item));
        assertTrue(store.getItemsFromStoreQueue().size() == 3);

        String s = null;
        do {
            s = store.popItemFromStoreQueue();
        } while (s != null);

        assertTrue(store.getItemsFromStoreQueue().size() == 0);
    }

}
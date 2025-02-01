package com.simplecachestorage.store;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KeyValueStoreTest {
    private KeyValueStore store;

    @BeforeEach
    void setUp() {
        store = new KeyValueStore();
    }

    @Test
    void putAndGetValue() {
        store.put("key1", "value1", 0);
        assertEquals("value1", store.get("key1"));
    }

    @Test
    void getExpiredValue() throws InterruptedException {
        store.put("key2", "value2", 100);
        Thread.sleep(150);
        assertNull(store.get("key2"));
    }

    @Test
    void deleteExistingKey() {
        store.put("key3", "value3", 0);
        assertTrue(store.delete("key3"));
        assertNull(store.get("key3"));
    }

    @Test
    void deleteNonExistingKey() {
        assertFalse(store.delete("nonexistent"));
    }

    @Test
    void putNullValue() {
        store.put("key4", null, 0);
        assertNull(store.get("key4"));
    }

    @Test
    void getNonExistingKey() {
        assertNull(store.get("nonexistent"));
    }
}
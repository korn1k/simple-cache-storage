package com.simplecachestorage.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class KeyValueEntryTest {

    @Test
    void testConstructorAndGetters() {
        KeyValueEntry entry = new KeyValueEntry("testKey", "testValue", 0);
        assertEquals("testKey", entry.getKey());
        assertEquals("testValue", entry.getValue());
    }

    @Test
    void testNoExpiration() {
        KeyValueEntry entry = new KeyValueEntry("key", "value", 0);
        assertFalse(entry.isExpired());
    }

    @Test
    void testNotExpired() {
        KeyValueEntry entry = new KeyValueEntry("key", "value", 10000); // 10 seconds
        assertFalse(entry.isExpired());
    }

    @Test
    void testExpired() throws InterruptedException {
        KeyValueEntry entry = new KeyValueEntry("key", "value", 100); // 100ms
        Thread.sleep(150); // Wait longer than TTL
        assertTrue(entry.isExpired());
    }
}
package com.simplecachestorage.store;

import java.util.concurrent.ConcurrentHashMap;

import com.simplecachestorage.model.KeyValueEntry;

public class KeyValueStore {
    private final ConcurrentHashMap<String, KeyValueEntry> storage = new ConcurrentHashMap<>();

    public void put(String key, String value, long ttlMillis) {
        storage.put(key, new KeyValueEntry(key, value, ttlMillis));
    }

    public String get(String key) {
        KeyValueEntry entry = storage.get(key);
        if (entry != null && !entry.isExpired()) {
            return entry.getValue();
        }
        return null;
    }

    public boolean delete(String key) {
        try {
            KeyValueEntry result = storage.remove(key);
            return result != null;
        } catch (NullPointerException e) {
            return false;
        }
    }
}

package com.simplecachestorage.server;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.simplecachestorage.model.KeyValueEntry;

public class KeyValueStore {
    private final ConcurrentHashMap<String, KeyValueEntry> store = new ConcurrentHashMap<>();
    private final ScheduledExecutorService cleaner = Executors.newScheduledThreadPool(1);

    public KeyValueStore() {
        cleaner.scheduleAtFixedRate(this::removeExpiredKeys, 0, 1, TimeUnit.SECONDS);
    }

    public synchronized String put(String key, String value, long ttlMillis) {
        store.put(key, new KeyValueEntry(key, value, ttlMillis));
        return "Put key: " + key + " value: " + value;
    }

    public synchronized String get(String key) {
        KeyValueEntry entry = store.get(key);
        if (entry == null || entry.isExpired()) {
            return "Key not found or expired";
        }

        return "Key: " + entry.getKey() + " value: " + entry.getValue();
    }

    public synchronized String delete(String key) {
        try {
            KeyValueEntry res = store.remove(key);
            if (res != null) {
                return "Deleted key: " + key;
            }
        } catch (NullPointerException e) {
        }

        return "Key not found";
    }

    private void removeExpiredKeys() {
        store.entrySet().removeIf(entry -> entry.getValue().isExpired());
    }
}

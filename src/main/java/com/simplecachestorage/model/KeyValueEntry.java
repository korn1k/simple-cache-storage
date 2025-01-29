package com.simplecachestorage.model;

public class KeyValueEntry {
    private final String key;
    private final String value;
    private final long expirationTime; // Unix timestamp (ms)

    public KeyValueEntry(String key, String value, long ttlMillis) {
        this.key = key;
        this.value = value;
        this.expirationTime = ttlMillis > 0 ? System.currentTimeMillis() + ttlMillis : 0;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public boolean isExpired() {
        // 0 means no expiration
        return expirationTime > 0 && System.currentTimeMillis() > expirationTime;
    }
}

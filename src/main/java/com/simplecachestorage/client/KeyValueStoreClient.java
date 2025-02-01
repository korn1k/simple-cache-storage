package com.simplecachestorage.client;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.simplecachestorage.DeleteRequest;
import com.simplecachestorage.GetRequest;
import com.simplecachestorage.GetResponse;
import com.simplecachestorage.KeyValueStoreGrpc;
import com.simplecachestorage.Main;
import com.simplecachestorage.PutRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class KeyValueStoreClient implements AutoCloseable {
    private final ManagedChannel channel;
    private final KeyValueStoreGrpc.KeyValueStoreBlockingStub client;
    private final Scanner scanner;
    private volatile boolean isRunning = true;

    public KeyValueStoreClient() {
        channel = ManagedChannelBuilder.forAddress(Main.HOST, Main.PORT)
                .usePlaintext()
                .build();
        client = KeyValueStoreGrpc.newBlockingStub(channel);
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.format("You are connected to Store on host '%s' and port '%d'\n", Main.HOST, Main.PORT);

        Runtime.getRuntime().addShutdownHook(new Thread(this::close));

        while (isRunning && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");

            String operation = parts[0].toLowerCase();
            String key = parts.length > 1 ? parts[1] : "no key";
            String value = parts.length > 2 ? parts[2] : "no value";
            long ttl = parts.length > 3 ? Long.parseLong(parts[3]) : 0;

            System.out.println(">");

            try {
                switch (operation) {
                    case "has" -> {
                        has(key);
                    }
                    case "put" -> {
                        put(key, value, ttl);
                    }
                    case "get" -> {
                        get(key);
                    }
                    case "delete" -> {
                        delete(key);
                    }
                    case "help" -> printHelp();
                    case "exit" -> {
                        return;
                    }
                    default -> System.out.println("Unknown command. Type 'help' for usage.");
                }
            } catch (Throwable e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void has(String key) {
        GetRequest request = GetRequest.newBuilder()
                .setKey(key)
                .build();
        GetResponse response = client.get(request);
        System.out.println("Key is " + (response.getFound() ? "found" : "not found"));
    }

    private void put(String key, String value, long ttl) {
        PutRequest request = PutRequest.newBuilder()
                .setKey(key)
                .setValue(value)
                .setTtl(ttl)
                .build();
        client.put(request);
        System.out.println("Value is added to Store");
    }

    private void get(String key) {
        GetRequest request = GetRequest.newBuilder()
                .setKey(key)
                .build();
        GetResponse response = client.get(request);
        if (response.getFound()) {
            System.out.println("Value is " + response.getValue());
        } else {
            System.out.println("Key is not found in Store");
        }
    }

    private void delete(String key) {
        DeleteRequest request = DeleteRequest.newBuilder()
                .setKey(key)
                .build();
        client.delete(request);
        System.out.println("Key is deleted from Store");
    }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("has <key>");
        System.out.println("put <key> <value> [ttl]");
        System.out.println("get <key>");
        System.out.println("delete <key>");
        System.out.println("help");
        System.out.println("exit");
    }

    @Override
    public void close() {
        isRunning = false;
        if (scanner != null) {
            scanner.close();
        }
        if (channel != null) {
            channel.shutdown();
            try {
                channel.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        try (KeyValueStoreClient client = new KeyValueStoreClient()) {
            client.start();
        }
    }
}

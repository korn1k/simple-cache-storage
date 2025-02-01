package com.simplecachestorage.client;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.simplecachestorage.DeleteRequest;
import com.simplecachestorage.GetRequest;
import com.simplecachestorage.GetResponse;
import com.simplecachestorage.KeyValueStoreGrpc;
import com.simplecachestorage.PutRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class KeyValueStoreClient implements AutoCloseable {
    private final ManagedChannel channel;
    private final KeyValueStoreGrpc.KeyValueStoreBlockingStub client;
    private final Scanner scanner;
    private volatile boolean isRunning = true;

    public KeyValueStoreClient() {
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        client = KeyValueStoreGrpc.newBlockingStub(channel);
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to KeyValueStore Client!");
        System.out.println("Available commands: put <key> <value> [ttl], get <key>, delete <key>, help, exit");

        Runtime.getRuntime().addShutdownHook(new Thread(this::close));

        while (isRunning && scanner.hasNextLine()) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");

            try {
                switch (parts[0].toLowerCase()) {
                    case "put" -> {
                        if (parts.length < 3) {
                            System.out.println("Usage: put <key> <value> [ttl]");
                            continue;
                        }
                        long ttl = parts.length > 3 ? Long.parseLong(parts[3]) : 0;
                        put(parts[1], parts[2], ttl);
                    }
                    case "get" -> {
                        if (parts.length != 2) {
                            System.out.println("Usage: get <key>");
                            continue;
                        }
                        get(parts[1]);
                    }
                    case "delete" -> {
                        if (parts.length != 2) {
                            System.out.println("Usage: delete <key>");
                            continue;
                        }
                        delete(parts[1]);
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

    private void put(String key, String value, long ttl) {
        PutRequest request = PutRequest.newBuilder()
                .setKey(key)
                .setValue(value)
                .setTtl(ttl)
                .build();
        client.put(request);
        System.out.println("Value stored successfully");
    }

    private void get(String key) {
        GetRequest request = GetRequest.newBuilder()
                .setKey(key)
                .build();
        GetResponse response = client.get(request);
        if (response.getFound()) {
            System.out.println("Value: " + response.getValue());
        } else {
            System.out.println("Key not found!");
        }
    }

    private void delete(String key) {
        DeleteRequest request = DeleteRequest.newBuilder()
                .setKey(key)
                .build();
        client.delete(request);
        System.out.println("Key deleted successfully");
    }

    private void printHelp() {
        System.out.println("Available commands:");
        System.out.println("  put <key> <value> [ttl] - Store a key-value pair");
        System.out.println("  get <key> - Retrieve a value by key");
        System.out.println("  delete <key> - Delete a key-value pair");
        System.out.println("  help - Show this help message");
        System.out.println("  exit - Exit the client");
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

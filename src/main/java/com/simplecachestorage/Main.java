package com.simplecachestorage;

import java.io.IOException;

import com.simplecachestorage.server.KeyValueStoreServer;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new KeyValueStoreServer())
                .build();

        System.out.println("Key-Value Store Server started on port 50051");
        server.start();
        server.awaitTermination();
    }
}

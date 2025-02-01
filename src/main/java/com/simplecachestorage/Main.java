package com.simplecachestorage;

import java.io.IOException;

import com.simplecachestorage.server.KeyValueStoreServer;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Main {
    public static final int PORT = 50051;
    public static final String HOST = "localhost";

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(Main.PORT)
                .addService(new KeyValueStoreServer())
                .build();

        System.out.format("Store has been launched on host '%s' and port '%d'", Main.HOST, Main.PORT);
        server.start();
        server.awaitTermination();
    }
}

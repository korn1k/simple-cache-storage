package com.simplecachestorage.server;

import com.simplecachestorage.KeyValueStoreGrpc;
import com.simplecachestorage.PutRequest;
import com.simplecachestorage.PutResponse;
import com.simplecachestorage.GetRequest;
import com.simplecachestorage.GetResponse;
import com.simplecachestorage.DeleteRequest;
import com.simplecachestorage.DeleteResponse;
import com.simplecachestorage.store.KeyValueStore;
import io.grpc.stub.StreamObserver;

public class KeyValueStoreServer extends KeyValueStoreGrpc.KeyValueStoreImplBase {
    private final KeyValueStore store = new KeyValueStore();

    @Override
    public void put(PutRequest request, StreamObserver<PutResponse> responseObserver) {
        store.put(request.getKey(), request.getValue(), request.getTtl());
        responseObserver.onNext(PutResponse.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();
    }

    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
        String value = store.get(request.getKey());
        boolean found = (value != null);
        responseObserver.onNext(GetResponse.newBuilder().setValue(value == null ? "" : value).setFound(found).build());
        responseObserver.onCompleted();
    }

    @Override
    public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
        boolean success = store.delete(request.getKey());
        responseObserver.onNext(DeleteResponse.newBuilder().setSuccess(success).build());
        responseObserver.onCompleted();
    }
}

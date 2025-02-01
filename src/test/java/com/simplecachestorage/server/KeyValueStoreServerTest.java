package com.simplecachestorage.server;

import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.simplecachestorage.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class KeyValueStoreServerTest {

    private KeyValueStoreServer server;

    @Mock
    private StreamObserver<PutResponse> putResponseObserver;
    @Mock
    private StreamObserver<GetResponse> getResponseObserver;
    @Mock
    private StreamObserver<DeleteResponse> deleteResponseObserver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        server = new KeyValueStoreServer();
    }

    @Test
    void testPutSuccess() {
        PutRequest request = PutRequest.newBuilder()
            .setKey("test-key")
            .setValue("test-value")
            .setTtl(0)
            .build();

        server.put(request, putResponseObserver);

        ArgumentCaptor<PutResponse> responseCaptor = ArgumentCaptor.forClass(PutResponse.class);
        verify(putResponseObserver).onNext(responseCaptor.capture());
        verify(putResponseObserver).onCompleted();

        PutResponse response = responseCaptor.getValue();
        assertTrue(response.getSuccess());
    }

    @Test
    void testGetExistingKey() {
        // Setup data
        PutRequest putRequest = PutRequest.newBuilder()
            .setKey("key1")
            .setValue("value1")
            .build();
        server.put(putRequest, putResponseObserver);

        // Test get
        GetRequest getRequest = GetRequest.newBuilder()
            .setKey("key1")
            .build();
        server.get(getRequest, getResponseObserver);

        ArgumentCaptor<GetResponse> responseCaptor = ArgumentCaptor.forClass(GetResponse.class);
        verify(getResponseObserver).onNext(responseCaptor.capture());
        verify(getResponseObserver).onCompleted();

        GetResponse response = responseCaptor.getValue();
        assertTrue(response.getFound());
        assertEquals("value1", response.getValue());
    }

    @Test
    void testGetExpiredKey() throws InterruptedException {
        // Setup data with TTL
        PutRequest putRequest = PutRequest.newBuilder()
            .setKey("key2")
            .setValue("value2")
            .setTtl(100) // 100ms TTL
            .build();
        server.put(putRequest, putResponseObserver);

        // Wait for expiration
        Thread.sleep(150);

        // Test get
        GetRequest getRequest = GetRequest.newBuilder()
            .setKey("key2")
            .build();
        server.get(getRequest, getResponseObserver);

        ArgumentCaptor<GetResponse> responseCaptor = ArgumentCaptor.forClass(GetResponse.class);
        verify(getResponseObserver).onNext(responseCaptor.capture());
        verify(getResponseObserver).onCompleted();

        GetResponse response = responseCaptor.getValue();
        assertFalse(response.getFound());
    }

    @Test
    void testDeleteKey() {
        // Setup data
        PutRequest putRequest = PutRequest.newBuilder()
            .setKey("key3")
            .setValue("value3")
            .build();
        server.put(putRequest, putResponseObserver);

        // Test delete
        DeleteRequest deleteRequest = DeleteRequest.newBuilder()
            .setKey("key3")
            .build();
        server.delete(deleteRequest, deleteResponseObserver);

        ArgumentCaptor<DeleteResponse> responseCaptor = ArgumentCaptor.forClass(DeleteResponse.class);
        verify(deleteResponseObserver).onNext(responseCaptor.capture());
        verify(deleteResponseObserver).onCompleted();

        DeleteResponse response = responseCaptor.getValue();
        assertTrue(response.getSuccess());
    }
}
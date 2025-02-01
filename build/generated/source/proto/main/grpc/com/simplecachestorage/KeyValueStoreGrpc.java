package com.simplecachestorage;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: keyvaluestore.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class KeyValueStoreGrpc {

  private KeyValueStoreGrpc() {}

  public static final String SERVICE_NAME = "com.simplecachestorage.KeyValueStore";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.simplecachestorage.PutRequest,
      com.simplecachestorage.PutResponse> getPutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Put",
      requestType = com.simplecachestorage.PutRequest.class,
      responseType = com.simplecachestorage.PutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.simplecachestorage.PutRequest,
      com.simplecachestorage.PutResponse> getPutMethod() {
    io.grpc.MethodDescriptor<com.simplecachestorage.PutRequest, com.simplecachestorage.PutResponse> getPutMethod;
    if ((getPutMethod = KeyValueStoreGrpc.getPutMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getPutMethod = KeyValueStoreGrpc.getPutMethod) == null) {
          KeyValueStoreGrpc.getPutMethod = getPutMethod =
              io.grpc.MethodDescriptor.<com.simplecachestorage.PutRequest, com.simplecachestorage.PutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Put"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simplecachestorage.PutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simplecachestorage.PutResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("Put"))
              .build();
        }
      }
    }
    return getPutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.simplecachestorage.GetRequest,
      com.simplecachestorage.GetResponse> getGetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Get",
      requestType = com.simplecachestorage.GetRequest.class,
      responseType = com.simplecachestorage.GetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.simplecachestorage.GetRequest,
      com.simplecachestorage.GetResponse> getGetMethod() {
    io.grpc.MethodDescriptor<com.simplecachestorage.GetRequest, com.simplecachestorage.GetResponse> getGetMethod;
    if ((getGetMethod = KeyValueStoreGrpc.getGetMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getGetMethod = KeyValueStoreGrpc.getGetMethod) == null) {
          KeyValueStoreGrpc.getGetMethod = getGetMethod =
              io.grpc.MethodDescriptor.<com.simplecachestorage.GetRequest, com.simplecachestorage.GetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Get"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simplecachestorage.GetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simplecachestorage.GetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("Get"))
              .build();
        }
      }
    }
    return getGetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.simplecachestorage.DeleteRequest,
      com.simplecachestorage.DeleteResponse> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.simplecachestorage.DeleteRequest.class,
      responseType = com.simplecachestorage.DeleteResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.simplecachestorage.DeleteRequest,
      com.simplecachestorage.DeleteResponse> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.simplecachestorage.DeleteRequest, com.simplecachestorage.DeleteResponse> getDeleteMethod;
    if ((getDeleteMethod = KeyValueStoreGrpc.getDeleteMethod) == null) {
      synchronized (KeyValueStoreGrpc.class) {
        if ((getDeleteMethod = KeyValueStoreGrpc.getDeleteMethod) == null) {
          KeyValueStoreGrpc.getDeleteMethod = getDeleteMethod =
              io.grpc.MethodDescriptor.<com.simplecachestorage.DeleteRequest, com.simplecachestorage.DeleteResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simplecachestorage.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.simplecachestorage.DeleteResponse.getDefaultInstance()))
              .setSchemaDescriptor(new KeyValueStoreMethodDescriptorSupplier("Delete"))
              .build();
        }
      }
    }
    return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KeyValueStoreStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyValueStoreStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KeyValueStoreStub>() {
        @java.lang.Override
        public KeyValueStoreStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KeyValueStoreStub(channel, callOptions);
        }
      };
    return KeyValueStoreStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KeyValueStoreBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyValueStoreBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KeyValueStoreBlockingStub>() {
        @java.lang.Override
        public KeyValueStoreBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KeyValueStoreBlockingStub(channel, callOptions);
        }
      };
    return KeyValueStoreBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KeyValueStoreFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<KeyValueStoreFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<KeyValueStoreFutureStub>() {
        @java.lang.Override
        public KeyValueStoreFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new KeyValueStoreFutureStub(channel, callOptions);
        }
      };
    return KeyValueStoreFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class KeyValueStoreImplBase implements io.grpc.BindableService {

    /**
     */
    public void put(com.simplecachestorage.PutRequest request,
        io.grpc.stub.StreamObserver<com.simplecachestorage.PutResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPutMethod(), responseObserver);
    }

    /**
     */
    public void get(com.simplecachestorage.GetRequest request,
        io.grpc.stub.StreamObserver<com.simplecachestorage.GetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.simplecachestorage.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.simplecachestorage.DeleteResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.simplecachestorage.PutRequest,
                com.simplecachestorage.PutResponse>(
                  this, METHODID_PUT)))
          .addMethod(
            getGetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.simplecachestorage.GetRequest,
                com.simplecachestorage.GetResponse>(
                  this, METHODID_GET)))
          .addMethod(
            getDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.simplecachestorage.DeleteRequest,
                com.simplecachestorage.DeleteResponse>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class KeyValueStoreStub extends io.grpc.stub.AbstractAsyncStub<KeyValueStoreStub> {
    private KeyValueStoreStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyValueStoreStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyValueStoreStub(channel, callOptions);
    }

    /**
     */
    public void put(com.simplecachestorage.PutRequest request,
        io.grpc.stub.StreamObserver<com.simplecachestorage.PutResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void get(com.simplecachestorage.GetRequest request,
        io.grpc.stub.StreamObserver<com.simplecachestorage.GetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.simplecachestorage.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.simplecachestorage.DeleteResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class KeyValueStoreBlockingStub extends io.grpc.stub.AbstractBlockingStub<KeyValueStoreBlockingStub> {
    private KeyValueStoreBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyValueStoreBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyValueStoreBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.simplecachestorage.PutResponse put(com.simplecachestorage.PutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPutMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.simplecachestorage.GetResponse get(com.simplecachestorage.GetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.simplecachestorage.DeleteResponse delete(com.simplecachestorage.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class KeyValueStoreFutureStub extends io.grpc.stub.AbstractFutureStub<KeyValueStoreFutureStub> {
    private KeyValueStoreFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KeyValueStoreFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new KeyValueStoreFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.simplecachestorage.PutResponse> put(
        com.simplecachestorage.PutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPutMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.simplecachestorage.GetResponse> get(
        com.simplecachestorage.GetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.simplecachestorage.DeleteResponse> delete(
        com.simplecachestorage.DeleteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PUT = 0;
  private static final int METHODID_GET = 1;
  private static final int METHODID_DELETE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KeyValueStoreImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KeyValueStoreImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PUT:
          serviceImpl.put((com.simplecachestorage.PutRequest) request,
              (io.grpc.stub.StreamObserver<com.simplecachestorage.PutResponse>) responseObserver);
          break;
        case METHODID_GET:
          serviceImpl.get((com.simplecachestorage.GetRequest) request,
              (io.grpc.stub.StreamObserver<com.simplecachestorage.GetResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.simplecachestorage.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.simplecachestorage.DeleteResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class KeyValueStoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KeyValueStoreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.simplecachestorage.Keyvaluestore.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("KeyValueStore");
    }
  }

  private static final class KeyValueStoreFileDescriptorSupplier
      extends KeyValueStoreBaseDescriptorSupplier {
    KeyValueStoreFileDescriptorSupplier() {}
  }

  private static final class KeyValueStoreMethodDescriptorSupplier
      extends KeyValueStoreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    KeyValueStoreMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (KeyValueStoreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KeyValueStoreFileDescriptorSupplier())
              .addMethod(getPutMethod())
              .addMethod(getGetMethod())
              .addMethod(getDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}

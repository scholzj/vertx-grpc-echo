package cz.scholz.grpcecho.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.1.2)",
    comments = "Source: echo.proto")
public class EchoGrpc {

  private EchoGrpc() {}

  private static <T> io.grpc.stub.StreamObserver<T> toObserver(final io.vertx.core.Handler<io.vertx.core.AsyncResult<T>> handler) {
    return new io.grpc.stub.StreamObserver<T>() {
      private volatile boolean resolved = false;
      @Override
      public void onNext(T value) {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.succeededFuture(value));
        }
      }

      @Override
      public void onError(Throwable t) {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.failedFuture(t));
        }
      }

      @Override
      public void onCompleted() {
        if (!resolved) {
          resolved = true;
          handler.handle(io.vertx.core.Future.succeededFuture());
        }
      }
    };
  }

  public static final String SERVICE_NAME = "echo.Echo";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<cz.scholz.grpcecho.proto.EchoRequest,
      cz.scholz.grpcecho.proto.EchoReply> METHOD_ECHO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "echo.Echo", "Echo"),
          io.grpc.protobuf.ProtoUtils.marshaller(cz.scholz.grpcecho.proto.EchoRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(cz.scholz.grpcecho.proto.EchoReply.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EchoStub newStub(io.grpc.Channel channel) {
    return new EchoStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EchoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new EchoBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static EchoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new EchoFutureStub(channel);
  }

  /**
   * Creates a new vertx stub that supports all call types for the service
   */
  public static EchoVertxStub newVertxStub(io.grpc.Channel channel) {
    return new EchoVertxStub(channel);
  }

  /**
   */
  public static abstract class EchoImplBase implements io.grpc.BindableService {

    /**
     */
    public void echo(cz.scholz.grpcecho.proto.EchoRequest request,
        io.grpc.stub.StreamObserver<cz.scholz.grpcecho.proto.EchoReply> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ECHO, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ECHO,
            asyncUnaryCall(
              new MethodHandlers<
                cz.scholz.grpcecho.proto.EchoRequest,
                cz.scholz.grpcecho.proto.EchoReply>(
                  this, METHODID_ECHO)))
          .build();
    }
  }

  /**
   */
  public static final class EchoStub extends io.grpc.stub.AbstractStub<EchoStub> {
    private EchoStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EchoStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EchoStub(channel, callOptions);
    }

    /**
     */
    public void echo(cz.scholz.grpcecho.proto.EchoRequest request,
        io.grpc.stub.StreamObserver<cz.scholz.grpcecho.proto.EchoReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class EchoBlockingStub extends io.grpc.stub.AbstractStub<EchoBlockingStub> {
    private EchoBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EchoBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EchoBlockingStub(channel, callOptions);
    }

    /**
     */
    public cz.scholz.grpcecho.proto.EchoReply echo(cz.scholz.grpcecho.proto.EchoRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ECHO, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class EchoFutureStub extends io.grpc.stub.AbstractStub<EchoFutureStub> {
    private EchoFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EchoFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EchoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cz.scholz.grpcecho.proto.EchoReply> echo(
        cz.scholz.grpcecho.proto.EchoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request);
    }
  }

  /**
   */
  public static abstract class EchoVertxImplBase implements io.grpc.BindableService {

    /**
     */
    public void echo(cz.scholz.grpcecho.proto.EchoRequest request,
        io.vertx.core.Future<cz.scholz.grpcecho.proto.EchoReply> response) {
      asyncUnimplementedUnaryCall(METHOD_ECHO, EchoGrpc.toObserver(response.completer()));
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ECHO,
            asyncUnaryCall(
              new VertxMethodHandlers<
                cz.scholz.grpcecho.proto.EchoRequest,
                cz.scholz.grpcecho.proto.EchoReply>(
                  this, METHODID_ECHO)))
          .build();
    }
  }

  /**
   */
  public static final class EchoVertxStub extends io.grpc.stub.AbstractStub<EchoVertxStub> {
    private EchoVertxStub(io.grpc.Channel channel) {
      super(channel);
    }

    private EchoVertxStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoVertxStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new EchoVertxStub(channel, callOptions);
    }

    /**
     */
    public void echo(cz.scholz.grpcecho.proto.EchoRequest request,
        io.vertx.core.Handler<io.vertx.core.AsyncResult<cz.scholz.grpcecho.proto.EchoReply>> response) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ECHO, getCallOptions()), request, EchoGrpc.toObserver(response));
    }
  }

  private static final int METHODID_ECHO = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EchoImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(EchoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ECHO:
          serviceImpl.echo((cz.scholz.grpcecho.proto.EchoRequest) request,
              (io.grpc.stub.StreamObserver<cz.scholz.grpcecho.proto.EchoReply>) responseObserver);
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

  private static class VertxMethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EchoVertxImplBase serviceImpl;
    private final int methodId;

    public VertxMethodHandlers(EchoVertxImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ECHO:
          serviceImpl.echo((cz.scholz.grpcecho.proto.EchoRequest) request,
              (io.vertx.core.Future<cz.scholz.grpcecho.proto.EchoReply>) io.vertx.core.Future.<cz.scholz.grpcecho.proto.EchoReply>future().setHandler(ar -> {
                if (ar.succeeded()) {
                  ((io.grpc.stub.StreamObserver<cz.scholz.grpcecho.proto.EchoReply>) responseObserver).onNext(ar.result());
                  responseObserver.onCompleted();
                } else {
                  responseObserver.onError(ar.cause());
                }
              }));
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

  private static final class EchoDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cz.scholz.grpcecho.proto.EchoProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EchoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EchoDescriptorSupplier())
              .addMethod(METHOD_ECHO)
              .build();
        }
      }
    }
    return result;
  }
}

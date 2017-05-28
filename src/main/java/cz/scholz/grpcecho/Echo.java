package cz.scholz.grpcecho;

import cz.scholz.grpcecho.proto.EchoGrpc;
import cz.scholz.grpcecho.proto.EchoReply;
import cz.scholz.grpcecho.proto.EchoRequest;
import io.grpc.ManagedChannel;
import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.grpc.VertxChannelBuilder;
import io.vertx.grpc.VertxServer;
import io.vertx.grpc.VertxServerBuilder;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by schojak on 10.1.17.
 */
public class Echo extends AbstractVerticle {
    final static private Logger LOG = LoggerFactory.getLogger(Echo.class);
    private ManagedChannel channel = null;
    private EchoGrpc.EchoVertxStub stub = null;
    private VertxServer rpcServer = null;
    private EchoGrpc.EchoVertxImplBase service = null;
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void start(Future<Void> fut)
    {
        ConfigStoreOptions envStore = new ConfigStoreOptions()
                .setType("env");
        ConfigRetrieverOptions options = new ConfigRetrieverOptions()
                .addStore(envStore);
        ConfigRetriever retriever = ConfigRetriever.create(vertx, options);

        retriever.getConfig(ar -> {
            if (ar.failed()) {
                LOG.error("Failed to get configuration", ar.cause());
                fut.fail(ar.cause());
            } else {
                JsonObject config = ar.result();

                if (config.getString("SERVICE_TYPE", "client").equals("server")) {
                    String grpcHost = config.getString("GRPC_HOSTNAME", "0.0.0.0");
                    Integer grpcPort = config.getInteger("GRPC_PORT", 8080);

                    LOG.info("Starting GRPC server on {}:{}", grpcHost, grpcPort);

                    service = new EchoGrpc.EchoVertxImplBase() {
                        @Override
                        public void echo(EchoRequest request, Future<EchoReply> response) {
                            LOG.info("Received request: {}", request.getMessage());
                            response.complete(EchoReply.newBuilder().setMessage(request.getMessage()).build());
                        }
                    };

                    rpcServer = VertxServerBuilder
                            .forAddress(vertx, grpcHost, grpcPort)
                            .addService(service)
                            .build();

                    // Start is asynchronous
                    rpcServer.start(res -> {
                        if (res.failed()) {
                            LOG.error("Failed to GRPC server", ar.cause());
                            fut.fail(ar.cause());
                        } else {
                            LOG.info("GPRC server is running");
                            fut.complete();
                        }
                    });
                }
                else {
                    String grpcHost = config.getString("GRPC_HOSTNAME", "localhost");
                    Integer grpcPort = config.getInteger("GRPC_PORT", 8080);
                    Integer timer = config.getInteger("TIMEOUT", 1000);

                    LOG.info("Starting GRPC client on {}:{}", grpcHost, grpcPort);

                    channel = VertxChannelBuilder
                            .forAddress(vertx,  grpcHost, grpcPort)
                            .usePlaintext(true)
                            .build();

                    stub = EchoGrpc.newVertxStub(channel);

                    vertx.setPeriodic(timer, id -> {
                        String message = "Echo " + counter.incrementAndGet();
                        LOG.info("Sending message: {}", message);
                        EchoRequest request = EchoRequest.newBuilder().setMessage(message).build();

                        stub.echo(request, res -> {
                            if (res.succeeded()) {
                                LOG.info("Received response: {}", res.result().getMessage());
                            } else {
                                LOG.error("Failed to get response", res.cause());
                            }
                        });
                    });

                    fut.complete();
                }
            }
        });
    }

    @Override
    public void stop() throws Exception {
        if (channel != null) {
            channel.shutdownNow();
        }

        if (rpcServer != null) {
            rpcServer.shutdownNow();
        }

        LOG.info("Shutting down");
        // Nothing to do
    }
}

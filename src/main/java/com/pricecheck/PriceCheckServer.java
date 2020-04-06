package com.pricecheck;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.pricecheck.module.PriceCheckModule;
import com.sun.net.httpserver.HttpServer;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Log4j2
public class PriceCheckServer {
    private Server server;
    private static final int PORT = 50051;

    private void start() throws IOException {
        final Injector injector = Guice.createInjector(new PriceCheckModule());

        server = ServerBuilder.forPort(PORT)
                .addService(injector.getInstance(PriceCheckService.class))
                .build()
                .start();

        log.info("Started server, listening on port {}", PORT);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                log.error("*** Shutting down gRPC Server since JVM is shutting down. ***");
                try {
                    PriceCheckServer.this.stop();
                } catch (InterruptedException ex) {
                    log.fatal("Caught exception while trying to shutdown gRPC server: ", ex);
                }
                log.error("*** Server shut down ***");
            }
        });
    }
    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(final String[] args) throws IOException, InterruptedException {
        final PriceCheckServer server = new PriceCheckServer();
        server.start();
        server.blockUntilShutdown();
    }
}

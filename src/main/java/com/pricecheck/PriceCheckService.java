package com.pricecheck;

import com.google.inject.Inject;
import com.pricecheck.orchestration.GetPricesOrchestrator;
import io.grpc.stub.StreamObserver;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

/**
 * Entry class for the PriceCheckService. This should have definitions for all of the APIs defined in the gRPC proto
 * files.
 */
@Log4j2
public class PriceCheckService extends PriceCheckGrpc.PriceCheckImplBase {
//    private final GetPricesOrchestrator getPricesOrchestrator;

    @Inject
    public PriceCheckService() { //@NonNull final GetPricesOrchestrator getPricesOrchestrator) {
//        this.getPricesOrchestrator = getPricesOrchestrator;
    }

    @Override
    public void getPrices(GetPricesRequest request, StreamObserver<GetPricesResponse> responseObserver) {
        log.info("Received getPrices request: {}", request);
        responseObserver.onNext(GetPricesResponse.newBuilder()
                .build());
        responseObserver.onCompleted();
    }
}

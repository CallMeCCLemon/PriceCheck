package com.pricecheck;

import com.google.inject.Inject;
import com.pricecheck.model.ItemPrice;
import com.pricecheck.orchestration.GetPricesOrchestrator;
import com.pricecheck.translator.api.ItemPriceTranslator;
import io.grpc.stub.StreamObserver;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Entry class for the PriceCheckService. This should have definitions for all of the APIs defined in the gRPC proto
 * files.
 */
@Log4j2
public class PriceCheckService extends PriceCheckGrpc.PriceCheckImplBase {
    private final GetPricesOrchestrator getPricesOrchestrator;

    @Inject
    public PriceCheckService(@NonNull final GetPricesOrchestrator getPricesOrchestrator) {
        this.getPricesOrchestrator = getPricesOrchestrator;
    }

    @Override
    public void getPrices(GetPricesRequest request, StreamObserver<GetPricesResponse> responseObserver) {
        log.info("Received getPrices request: {}", request);

        final List<ItemPrice> itemPrices = getPricesOrchestrator.orchestrate(request.getSku());

        final List<Price> prices = itemPrices.stream()
                .map(ItemPriceTranslator::toPrice)
                .collect(Collectors.toList());

        for (int index = 0; index < prices.size(); index ++) {
            responseObserver.onNext(GetPricesResponse.newBuilder()
                    .setPrices(index, prices.get(index))
                    .build());
        }

        responseObserver.onCompleted();
    }
}

package com.pricecheck.orchestration;

import com.pricecheck.model.ItemPrice;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class GetPricesOrchestrator {
    /**
     * Default contsructor.
     */
    public GetPricesOrchestrator() {

    }

    public List<ItemPrice> orchestrate(@NonNull final String sku) {
        final List<ItemPrice> itemPrices = new ArrayList<>();

        return itemPrices;
    }
}

package com.pricecheck.translator.api;

import com.pricecheck.Price;
import com.pricecheck.model.ItemPrice;
import lombok.NonNull;

public class ItemPriceTranslator {
    public static Price toPrice(@NonNull final ItemPrice itemPrice) {
        return Price.newBuilder()
                .setPrice(itemPrice.getPrice())
                .setSeller(itemPrice.getSellerName())
                .setSellerWebsite(itemPrice.getSellerWebsite())
                .build();
    }
}

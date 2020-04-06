package com.pricecheck.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ItemPrice {
    double price;

    String SellerName;

    String SellerWebsite;
}

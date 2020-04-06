package com.pricecheck.translation.api

import com.pricecheck.Price
import com.pricecheck.model.ItemPrice
import com.pricecheck.translator.api.ItemPriceTranslator
import spock.lang.Specification

class ItemPriceTranslatorTest extends Specification {

    private static final double PRICE_VALUE = 0.25
    private static final String SELLER_NAME = "DummiesRus"
    private static final String SELLER_WEBSITE = "DummiesRUs.com"


    def "Translating an ItemPrice to Price correctly copies all attributes"() {
        given: "An item price to translate"
        final ItemPrice itemPrice = ItemPrice.builder()
                .price(PRICE_VALUE)
                .SellerName(SELLER_NAME)
                .SellerWebsite(SELLER_WEBSITE)
                .build()

        when: "Translating the item price"
        final Price price = ItemPriceTranslator.toPrice(itemPrice)

        then: "The attributes are correctly copied over"
        price.getPrice() == PRICE_VALUE
        price.getSeller() == SELLER_NAME
        price.getSellerWebsite() == SELLER_WEBSITE
    }
}

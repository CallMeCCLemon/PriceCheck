package com.pricecheck.orchestration

import com.pricecheck.model.ItemPrice
import spock.lang.Specification

class GetPricesOrchestratorTest extends Specification {

    private GetPricesOrchestrator getPricesOrchestrator
    private static final DUMMY_SKU = "DUMMYSKU"

    def setup() {
        getPricesOrchestrator = new GetPricesOrchestrator()
    }

    def "Orchestrator returns empty list of prices because DDB connection isn't configured"() {
        when: "Getting the prices for an item"
        List<ItemPrice> itemPrices = getPricesOrchestrator.orchestrate(DUMMY_SKU)

        then: "the list should be empty"
        itemPrices.isEmpty()
    }
}

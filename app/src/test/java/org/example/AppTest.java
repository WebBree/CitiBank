package org.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

class AppTest {
    // Test to verify successful API connection
    @Test
    void testConnection() throws IOException {
        Stock dowJones = YahooFinance.get("^DJI");
        assertNotNull(dowJones);
    }

    // Test to verify successful retrieval of stock data
    @Test
    void testStockData() throws IOException {
        Stock dowJones = YahooFinance.get("^DJI");
        assertNotNull(dowJones.getQuote().getPrice());
    }
}

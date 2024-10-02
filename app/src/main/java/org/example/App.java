package org.example;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;

public class App {

    private static Queue<String> stockDataQueue = new LinkedList<>();

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new FetchStockTask(), 0, 5000); // Fetch every 5 seconds
    }

    static class FetchStockTask extends TimerTask {
        @Override
        public void run() {
            try {
                Stock dowJones = YahooFinance.get("^DJI");
                BigDecimal price = dowJones.getQuote().getPrice();
                LocalDateTime timestamp = LocalDateTime.now();
                String stockData = "Time: " + timestamp + ", Dow Jones Price: " + price;
                stockDataQueue.add(stockData);
                System.out.println(stockData);
            } catch (IOException e) {
                System.err.println("Error fetching stock data: " + e.getMessage());
            }
        }
    }
}

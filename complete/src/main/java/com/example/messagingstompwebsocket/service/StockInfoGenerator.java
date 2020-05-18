package com.example.messagingstompwebsocket.service;

import com.example.messagingstompwebsocket.model.ExternalStockInfo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StockInfoGenerator {

    public static final String STOCK_SYMBOL = "SYMBOL";

    /* Normally stock pricing info would be taken from an external web service */
    public ExternalStockInfo getQuote() {
        double price = getRandomBetween(0.0, 100.0);
        double spread = getRandomBetween(0.0, price);
        return new ExternalStockInfo(STOCK_SYMBOL, price + spread / 2.0, price - spread / 2.0, LocalDateTime.now());
    }

    private static double getRandomBetween(double min, double max) {
        return Math.random() * ((max - min) + 1) + min;
    }

}

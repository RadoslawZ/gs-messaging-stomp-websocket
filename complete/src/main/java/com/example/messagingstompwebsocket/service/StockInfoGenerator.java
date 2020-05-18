package com.example.messagingstompwebsocket.service;

import com.example.messagingstompwebsocket.model.ExternalStockInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class StockInfoGenerator {

    @Value("${stock.prices.demo.symbol}")
    private String stockSymbol;

    /* This is for DEMO: Normally stock pricing info would be taken from an external web service */
    public ExternalStockInfo getQuote() {
        double price = getRandomBetween(0.0, 100.0);
        double spread = getRandomBetween(0.0, price);
        return new ExternalStockInfo(stockSymbol, price + spread / 2.0, price - spread / 2.0, LocalDateTime.now());
    }

    private static double getRandomBetween(double min, double max) {
        return Math.random() * ((max - min) + 1) + min;
    }

}

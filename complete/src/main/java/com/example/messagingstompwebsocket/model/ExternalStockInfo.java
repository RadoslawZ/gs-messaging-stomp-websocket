package com.example.messagingstompwebsocket.model;

import java.time.LocalDateTime;

public class ExternalStockInfo {

    private String symbol;
    private Double bidPrice;
    private Double askPrice;
    private LocalDateTime time;


    public ExternalStockInfo(String symbol, Double bidPrice, Double askPrice, LocalDateTime time) {
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.time = time;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Double askPrice) {
        this.askPrice = askPrice;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}

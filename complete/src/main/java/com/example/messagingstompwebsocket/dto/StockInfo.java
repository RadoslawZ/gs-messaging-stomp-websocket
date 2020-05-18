package com.example.messagingstompwebsocket.dto;

public class StockInfo {

    private String symbol;
    private String price;
    private String arrow;

    public StockInfo() {
    }

    public StockInfo(String symbol, String price, String arrow) {
        this.symbol = symbol;
        this.price = price;
        this.arrow = arrow;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getArrow() {
        return arrow;
    }

    public void setArrow(String arrow) {
        this.arrow = arrow;
    }

}

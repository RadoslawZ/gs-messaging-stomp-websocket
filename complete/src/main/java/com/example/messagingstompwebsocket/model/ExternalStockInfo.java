package com.example.messagingstompwebsocket.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExternalStockInfo {

    private String symbol;
    private Double bidPrice;
    private Double askPrice;
    private LocalDateTime time;

}

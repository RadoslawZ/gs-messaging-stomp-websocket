package com.example.messagingstompwebsocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockInfo {

    private String symbol;
    private String price;
    private String trend;

}

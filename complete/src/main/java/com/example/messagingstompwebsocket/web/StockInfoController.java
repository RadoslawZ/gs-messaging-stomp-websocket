package com.example.messagingstompwebsocket.web;

import com.example.messagingstompwebsocket.service.StockInfoService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class StockInfoController {

    final StockInfoService stockInfoService;

    public StockInfoController(StockInfoService stockInfoService) {
        this.stockInfoService = stockInfoService;
    }

    @MessageMapping("/stockinfo.start")
    public void stockInfoStartAction() throws Exception {
        stockInfoService.queryStockInfoAndSendToTopic();
    }

}

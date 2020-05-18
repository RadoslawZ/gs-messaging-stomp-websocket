package com.example.messagingstompwebsocket.web;

import com.example.messagingstompwebsocket.service.StockInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class StockInfoController {

    final StockInfoService stockInfoService;

    @MessageMapping("/stockinfo.start")
    public void stockInfoStartAction() throws Exception {
        stockInfoService.queryStockInfoAndSendToTopic();
    }

}

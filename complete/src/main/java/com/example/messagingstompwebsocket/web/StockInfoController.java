package com.example.messagingstompwebsocket.web;

import com.example.messagingstompwebsocket.dto.StockInfo;
import com.example.messagingstompwebsocket.service.StockInfoService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class StockInfoController {

	final StockInfoService stockInfoService;

	public StockInfoController(StockInfoService stockInfoService) {
		this.stockInfoService = stockInfoService;
	}

	@MessageMapping("/stockinfo")
    @SendTo("/topic/stockinfos")
    public StockInfo stockInfo() throws Exception {
        Thread.sleep(500); // simulated delay
        return new StockInfo("Symbol", "Price" + Math.random(), "Arrow Up");
    }

    @MessageMapping("/stockinfo.start")
    public void stockInfoStartAction() throws Exception {
		stockInfoService.queryStockInfoAndSendToTopic();
    }

}

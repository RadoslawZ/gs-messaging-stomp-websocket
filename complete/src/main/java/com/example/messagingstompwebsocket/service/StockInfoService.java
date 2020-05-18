package com.example.messagingstompwebsocket.service;

import com.example.messagingstompwebsocket.dto.StockInfo;
import com.example.messagingstompwebsocket.model.StockInfoExternal;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class StockInfoService {

    final StockInfoGenerator stockInfoGenerator;
    final SimpMessagingTemplate simpMessagingTemplate;

    public StockInfoService(StockInfoGenerator stockInfoGenerator, SimpMessagingTemplate simpMessagingTemplate) {
        this.stockInfoGenerator = stockInfoGenerator;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void queryStockInfoAndSendToTopic() throws Exception {

        // TODO: Querying 100 times for now in order to avoid the infinite loop
        Double previousMarketPrice = -1.0;
        for (int i = 0; i < 100; i++) {
            StockInfoExternal externalInfo = stockInfoGenerator.getQuote();
            Double marketPrice = (externalInfo.getBidPrice() + externalInfo.getAskPrice()) / 2.0;
            String arrow = "";
            if (previousMarketPrice < 0.0) {
                arrow = "none";
            } else {
                if (marketPrice > previousMarketPrice) {
                    arrow = "up";
                } else if (marketPrice == previousMarketPrice) {
                    arrow = "equal";
                } else if (marketPrice < previousMarketPrice) {
                    arrow = "down";
                }
            }
            previousMarketPrice = marketPrice;
            StockInfo stockInfo = new StockInfo(externalInfo.getSymbol(), String.format("%.2f", marketPrice), arrow);
            sendToTopic(stockInfo);
        }
    }

    private void sendToTopic(StockInfo stockInfo) /* throws Exception */ {
        // Thread.sleep(500); // simulated delay
        simpMessagingTemplate.convertAndSend("/topic/stockinfos", stockInfo);
    }
}

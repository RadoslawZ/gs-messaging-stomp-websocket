package com.example.messagingstompwebsocket.service;

import com.example.messagingstompwebsocket.dto.StockInfo;
import com.example.messagingstompwebsocket.dto.StockInfo.Trend;
import com.example.messagingstompwebsocket.model.ExternalStockInfo;
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

        // TODO: Extract the number of iterations (for DEMO) to an external variable
        Double previousMarketPrice = null;
        for (int i = 0; i < 10; i++) {
            ExternalStockInfo externalInfo = stockInfoGenerator.getQuote();
            Double marketPrice = (externalInfo.getBidPrice() + externalInfo.getAskPrice()) / 2.0;
            StockInfo.Trend trend = Trend.NONE;
            if (previousMarketPrice != null) {
                if (marketPrice > previousMarketPrice) {
                    trend = Trend.UP;
                } else if (marketPrice == previousMarketPrice) {
                    trend = Trend.CONSTANT;
                } else if (marketPrice < previousMarketPrice) {
                    trend = Trend.DOWN;
                }
            }
            previousMarketPrice = marketPrice;
            StockInfo stockInfo = new StockInfo(externalInfo.getSymbol(), String.format("%.2f", marketPrice), trend.toString());
            sendToTopic(stockInfo);
        }
    }

    private void sendToTopic(StockInfo stockInfo) {
        simpMessagingTemplate.convertAndSend("/topic/stockinfos", stockInfo);
    }
}

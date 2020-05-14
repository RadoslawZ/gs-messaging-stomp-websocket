package com.example.messagingstompwebsocket.controller;

import com.example.messagingstompwebsocket.dto.Greeting;
import com.example.messagingstompwebsocket.dto.HelloMessage;
import com.example.messagingstompwebsocket.dto.StockInfo;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class StockInfoController {


	@MessageMapping("/stockinfo")
	@SendTo("/topic/stockinfos")
	public StockInfo stockInfo() throws Exception {
		Thread.sleep(1000); // simulated delay
		return new StockInfo("Symbol", "Price", "Arrow Up");
	}

}

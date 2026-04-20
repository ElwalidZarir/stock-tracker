package com.portfolio_1.demo.service;

import com.portfolio_1.demo.client.StockClient;
import com.portfolio_1.demo.dto.AlphaVantageResponse;
import com.portfolio_1.demo.dto.StockResponse;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockClient stockClient;

    public StockService(final StockClient stockClient) {
        this.stockClient = stockClient;
    }

    public StockResponse getStock(final String symbol){
        final AlphaVantageResponse response = stockClient.getStockQuote(symbol);
        return StockResponse.builder()
                .symbol(response.globalQuote().symbol())
                .price(Double.parseDouble(response.globalQuote().price()))
                .lastUpdated(response.globalQuote().lastTradingDay())
                .build();
    }
}

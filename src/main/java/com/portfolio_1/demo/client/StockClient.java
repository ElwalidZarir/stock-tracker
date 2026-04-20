package com.portfolio_1.demo.client;

import com.portfolio_1.demo.dto.AlphaVantageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class StockClient {
     private final WebClient webClient;

     @Value("${alpha.vantage.api.key}")
     public String apiKey;

     public AlphaVantageResponse getStockQuote(String symbol){
         return webClient.get().uri(uriBuilder -> uriBuilder
                 .queryParam("function", "GLOBAL_QUOTE")
                 .queryParam("symbol", symbol)
                 .queryParam("apikey", apiKey)
                 .build())
                 .retrieve().bodyToMono(AlphaVantageResponse.class).block();
     }


}

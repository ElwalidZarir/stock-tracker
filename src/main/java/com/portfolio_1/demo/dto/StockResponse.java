package com.portfolio_1.demo.dto;

import lombok.Builder;
import org.springframework.expression.spel.ast.StringLiteral;

@Builder
public record StockResponse(
        String symbol,
        double price,
        String lastUpdated
) {
}

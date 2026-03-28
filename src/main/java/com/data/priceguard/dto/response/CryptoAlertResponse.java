package com.data.priceguard.dto.response;

import java.math.BigDecimal;

public record CryptoAlertResponse(
        String symbol,
        BigDecimal price
) {
    public BigDecimal getPrice() {
        return price;
    }
}

package com.data.priceguard.dto.request;

import java.math.BigDecimal;

public record CryptoAlertRequest(
        String symbol,
        BigDecimal price
) {}

package com.data.priceguard.dto;

import java.math.BigDecimal;

public record CryptoAlert(
        String symbol,
        BigDecimal price
) {}

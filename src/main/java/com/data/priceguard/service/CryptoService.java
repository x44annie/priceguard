package com.data.priceguard.service;

import com.data.priceguard.dto.request.CryptoAlertRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public abstract class CryptoService {
    public abstract Mono<CryptoAlertRequest> fetchPrice(String symbol);
}
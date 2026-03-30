package com.data.priceguard.service;

import com.data.priceguard.dto.request.CryptoAlertRequest;
import com.data.priceguard.dto.response.CryptoAlertResponse;
import com.data.priceguard.exception.BinancePriceException;
import com.data.priceguard.mapper.CryptoAlertMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
public class BinanceCryptoService extends CryptoService {
    private final WebClient webClient;
    private final CryptoAlertMapper mapper;

    public BinanceCryptoService(@Value("${binance.api.base-url}") String baseUrl, CryptoAlertMapper mapper) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
        this.mapper = mapper;
    }

    @Override
    public Mono<CryptoAlertRequest> fetchPrice(String symbol) {
        return webClient.get()
                .uri(urlBuilder -> urlBuilder
                        .path("/api/v3/ticker/price")
                        .queryParam("symbol", symbol)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::isError, clientResponse ->
                        clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new BinancePriceException("Binance API error" + errorBody)
                                ))
                )
                .bodyToMono(CryptoAlertResponse.class)
                .map(response -> mapper.toRequest(symbol, response))
                .timeout(Duration.ofSeconds(3))
                .retryWhen(Retry.backoff(2, Duration.ofMillis(400))
                        .filter(error -> !(error instanceof BinancePriceException))
                )
                .onErrorMap(error -> !(error instanceof BinancePriceException),
                        error -> new BinancePriceException("Failed to fetch price for " + symbol + ": " + error.getMessage())
                );
    }
}

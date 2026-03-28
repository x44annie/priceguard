package com.data.priceguard.mapper;

import com.data.priceguard.dto.request.CryptoAlertRequest;
import com.data.priceguard.dto.response.CryptoAlertResponse;
import org.springframework.stereotype.Component;

@Component
public class CryptoAlertMapper {

    public CryptoAlertRequest toRequest(String symbol, CryptoAlertResponse response) {
        return new CryptoAlertRequest(symbol, response.getPrice());
    }
}

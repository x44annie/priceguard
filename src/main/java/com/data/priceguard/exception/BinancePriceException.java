package com.data.priceguard.exception;

public class BinancePriceException extends RuntimeException {

    public BinancePriceException(String message) {
        super(message);
    }

    public BinancePriceException(String message, Throwable cause) {
        super(message, cause);
    }
}

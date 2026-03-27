package com.data.priceguard.dto.request;

public record UserLoginRequest(
        String email,
        String password
) {
}

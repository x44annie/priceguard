package com.data.priceguard.dto.request;

public record UserRegisterRequest(
    String email,
    String password
) {}

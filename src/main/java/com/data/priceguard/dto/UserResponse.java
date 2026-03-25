package com.data.priceguard.dto;

import java.util.UUID;

public record UserResponse(
        UUID uid,
        String email
) {}

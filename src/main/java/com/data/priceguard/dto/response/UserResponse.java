package com.data.priceguard.dto.response;

import java.util.UUID;

public record UserResponse(
        UUID uid,
        String email
) {}

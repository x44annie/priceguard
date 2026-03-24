package com.data.priceguard.controller;

import com.data.priceguard.dto.UserLogin;
import com.data.priceguard.dto.UserRegister;
import com.data.priceguard.dto.UserResponse;
import com.data.priceguard.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(
        origins = {
                "http://localhost",
                "http://localhost:3000",
                "http://127.0.0.1",
        },
        allowCredentials = "true"
)
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRegister dto) {
        UserResponse response = authService.register(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserLogin dto) {
        UserResponse response = authService.login(dto);
        return ResponseEntity.ok(response);
    }
}

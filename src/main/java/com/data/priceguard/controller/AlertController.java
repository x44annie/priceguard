package com.data.priceguard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
public class AlertController {

    @GetMapping("/crypto")
    public ResponseEntity<String> crypto() {
        return null;
    }

    @GetMapping("/stocks")
    public ResponseEntity<String> stocks() {
        return null;
    }
}

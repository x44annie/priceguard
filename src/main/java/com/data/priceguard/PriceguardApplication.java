package com.data.priceguard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PriceguardApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceguardApplication.class, args);
    }

}

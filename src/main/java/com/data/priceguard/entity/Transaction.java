package com.data.priceguard.entity;

import com.fasterxml.uuid.Generators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "txn")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false, columnDefinition = "uuid")
    private UUID uid = Generators.timeBasedEpochGenerator().generate();

    private String symbol;
    private String price;
    private String time;
}

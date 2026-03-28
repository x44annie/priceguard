package com.data.priceguard.entity;

import com.fasterxml.uuid.Generators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name = "txn")
@EqualsAndHashCode(callSuper = false)
public class Transaction extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false, columnDefinition = "uuid DEFAULT uuidv7()")
    private UUID uid = Generators.timeBasedEpochGenerator().generate();

    private String symbol;
    private BigDecimal price;
}
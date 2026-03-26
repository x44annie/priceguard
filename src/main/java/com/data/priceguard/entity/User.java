package com.data.priceguard.entity;

import com.fasterxml.uuid.Generators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@EqualsAndHashCode(callSuper = false)
public class User extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false, columnDefinition = "uuid DEFAULT uuidv7()")
    private UUID uid = Generators.timeBasedEpochGenerator().generate();

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String passwordHint;
}
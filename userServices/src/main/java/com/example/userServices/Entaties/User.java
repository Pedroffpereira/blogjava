package com.example.userServices.Entaties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @GeneratedValue
    @Id
    UUID id;
    @NotNull
    String name;
    @Email
    @NotNull
    String email;
    @NotNull
    String password;

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private Type type;
}

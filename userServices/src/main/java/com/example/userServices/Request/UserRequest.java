package com.example.userServices.Request;

import com.example.userServices.Entaties.Type;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotNull
    String name;
    @Email
    @NotNull
    String email;
    @NotNull
    String password;
    Type type;
}

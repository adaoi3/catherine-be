package com.goodsoft.catherinebe.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthenticationDto {

    @NotNull
    @Size(min = 2, max = 25)
    private String login;
    @Size(min = 4, max = 30)
    @NotNull
    private String password;

}

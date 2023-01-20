package com.goodsoft.catherinebe.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginDto {

    @Size(min = 2, max = 25)
    private String login;
    @Size(min = 4, max = 30)
    private String password;

}
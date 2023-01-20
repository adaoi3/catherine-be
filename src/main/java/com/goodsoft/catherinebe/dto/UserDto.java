package com.goodsoft.catherinebe.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserDto {

    private Long id;
    @Size(min = 2, max = 25)
    private String firstName;
    @Size(min = 2, max = 25)
    private String lastName;
    @Size(min = 2, max = 25)
    private String login;
    @Size(min = 4, max = 30)
    private String password;
    @Size(min = 6, max = 30)
    private String email;
    @NotNull
    @NotEmpty
    private List<String> roles;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

}

package com.goodsoft.catherinebe.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeclineBookingDto {

    @NotNull
    private Long id;
    @NotNull
    private Long adminId;
    @NotNull
    private String status;

}

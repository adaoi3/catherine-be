package com.goodsoft.catherinebe.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConfirmBookingDto {

    @NotNull
    private Long id;
    @NotNull
    private Long adminId;
    @NotNull
    private Integer roomId;
    @NotNull
    private String status;

}

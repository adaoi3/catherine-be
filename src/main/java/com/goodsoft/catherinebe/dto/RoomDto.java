package com.goodsoft.catherinebe.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomDto {

    @NotNull
    private Integer id;
    @NotNull
    private Integer capacity;
    @NotNull
    @NotEmpty
    private String roomType;

}

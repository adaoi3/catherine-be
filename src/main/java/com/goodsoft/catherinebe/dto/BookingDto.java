package com.goodsoft.catherinebe.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
public class BookingDto {

    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private Integer personCount;
    @NotNull
    @NotEmpty
    private String roomType;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate stayTimeStart;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate stayTimeEnd;
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private LocalDateTime bookingDate;

}

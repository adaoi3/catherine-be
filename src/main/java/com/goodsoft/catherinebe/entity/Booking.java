package com.goodsoft.catherinebe.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Booking {

    private Long id;
    private Long userId;
    private Integer personCount;
    private RoomType roomType;
    private LocalDate stayTimeStart;
    private LocalDate stayTimeEnd;
    private LocalDateTime bookingDate;

}

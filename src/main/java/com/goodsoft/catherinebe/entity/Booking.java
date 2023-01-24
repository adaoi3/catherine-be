package com.goodsoft.catherinebe.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Booking {

    private Long id;
    private Long userId;
    private Integer places;
    private RoomType roomType;
    private LocalDate stayTimeStart;
    private LocalDate stayTimeEnd;
    private LocalDate bookingDate;

}

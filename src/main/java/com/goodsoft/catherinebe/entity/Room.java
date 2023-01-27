package com.goodsoft.catherinebe.entity;

import lombok.Data;

@Data
public class Room {

    private Long id;
    private Integer personCount;
    private RoomType roomType;

}

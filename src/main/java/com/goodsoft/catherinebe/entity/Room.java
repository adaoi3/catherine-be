package com.goodsoft.catherinebe.entity;

import lombok.Data;

@Data
public class Room {

    private Integer id;
    private Integer capacity;
    private RoomType roomType;

}

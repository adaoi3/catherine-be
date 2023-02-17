package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.dto.RoomDto;
import com.goodsoft.catherinebe.entity.Room;
import java.time.LocalDate;
import java.util.List;

public interface RoomService {

    List<RoomDto> getAvailableRooms(LocalDate stayTimeStart, LocalDate stayTimeEnd,
        String roomType, String status);

    RoomDto convertToRoomDto(Room room);
}

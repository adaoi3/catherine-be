package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.dao.RoomDao;
import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.dto.RoomDto;
import com.goodsoft.catherinebe.entity.Room;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomDao roomDao;

    @Override
    public List<RoomDto> getAvailableRooms(LocalDate stayTimeStart, LocalDate stayTimeEnd,
        String roomType, String status) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setStayTimeStart(stayTimeStart);
        bookingDto.setStayTimeEnd(stayTimeEnd);
        bookingDto.setRoomType(roomType.toUpperCase());
        bookingDto.setStatus(status);
        return roomDao.getAvailableRooms(bookingDto)
            .stream()
            .map(this::convertToRoomDto)
            .toList();
    }

    @Override
    public RoomDto convertToRoomDto(Room room) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(room.getId());
        roomDto.setCapacity(room.getCapacity());
        roomDto.setRoomType(room.getRoomType().getName());
        return roomDto;
    }

}

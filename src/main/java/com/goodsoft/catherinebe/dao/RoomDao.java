package com.goodsoft.catherinebe.dao;

import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.entity.Room;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoomDao {

    Room readById(Integer roomId);

    List<Room> getAvailableRooms(BookingDto bookingDto);

}

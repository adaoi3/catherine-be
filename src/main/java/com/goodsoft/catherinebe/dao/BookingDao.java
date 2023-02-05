package com.goodsoft.catherinebe.dao;

import com.goodsoft.catherinebe.entity.Booking;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookingDao {

    void create(Booking booking);
    List<Booking> readByStatus(String statusName);
    void update(Booking booking);

}

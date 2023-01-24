package com.goodsoft.catherinebe.dao;

import com.goodsoft.catherinebe.entity.Booking;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookingDao {

    void create(Booking booking);

}

package com.goodsoft.catherinebe.dao;

import com.goodsoft.catherinebe.dto.ConfirmBookingDto;
import com.goodsoft.catherinebe.dto.DeclineBookingDto;
import com.goodsoft.catherinebe.entity.Booking;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookingDao {

    void create(Booking booking);

    List<Booking> readByStatus(String statusName);

    List<Booking> readByUserId(Long userId);

    void confirm(ConfirmBookingDto confirmBookingDto);

    void decline(DeclineBookingDto declineBookingDto);

    void delete(Long id);

}

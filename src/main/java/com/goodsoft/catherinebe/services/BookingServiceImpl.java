package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.dao.BookingDao;
import com.goodsoft.catherinebe.dao.RoomTypeDao;
import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.entity.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingDao bookingDao;
    private final RoomTypeDao roomTypeDao;

    @Override
    public void create(BookingDto bookingDto) {
        bookingDao.create(convertToBooking(bookingDto));
    }

    @Override
    public Booking convertToBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setUserId(bookingDto.getUserId());
        booking.setPlaces(bookingDto.getPlaces());
        booking.setRoomType(roomTypeDao.readByName(bookingDto.getRoomType().toUpperCase()));
        booking.setStayTimeStart(bookingDto.getStayTimeStart());
        booking.setStayTimeEnd(bookingDto.getStayTimeEnd());
        booking.setBookingDate(bookingDto.getBookingDate());
        return booking;
    }

}

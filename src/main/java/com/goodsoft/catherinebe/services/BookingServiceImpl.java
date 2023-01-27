package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.dao.BookingDao;
import com.goodsoft.catherinebe.dao.BookingStatusDao;
import com.goodsoft.catherinebe.dao.RoomTypeDao;
import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.entity.Booking;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingDao bookingDao;
    private final RoomTypeDao roomTypeDao;
    private final BookingStatusDao bookingStatusDao;

    @Override
    public void create(BookingDto bookingDto) {
        bookingDao.create(convertToBooking(bookingDto));
    }

    @Override
    public List<BookingDto> getAll() {
        return bookingDao.readAll()
            .stream()
            .map(this::convertToBookingDto)
            .collect(Collectors.toList());
    }

    @Override
    public Booking convertToBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setUserId(bookingDto.getUserId());
        booking.setAdminId(bookingDto.getAdminId());
        booking.setPersonCount(bookingDto.getPersonCount());
        booking.setRoomType(roomTypeDao.readByName(bookingDto.getRoomType().toUpperCase()));
        booking.setStayTimeStart(bookingDto.getStayTimeStart());
        booking.setStayTimeEnd(bookingDto.getStayTimeEnd());
        booking.setBookingDate(Timestamp.from(Instant.now()).toLocalDateTime());
        return booking;
    }

    @Override
    public BookingDto convertToBookingDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setUserId(booking.getUserId());
        bookingDto.setAdminId(booking.getAdminId());
        bookingDto.setStatus(bookingStatusDao.readNameById(booking.getStatus().getId()));
        bookingDto.setPersonCount(booking.getPersonCount());
        bookingDto.setRoomType(roomTypeDao.readNameById(booking.getRoomType().getId()));
        bookingDto.setStayTimeStart(booking.getStayTimeStart());
        bookingDto.setStayTimeEnd(booking.getStayTimeEnd());
        bookingDto.setBookingDate(booking.getBookingDate());
        return bookingDto;
    }

}

package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.dao.BookingDao;
import com.goodsoft.catherinebe.dao.BookingStatusDao;
import com.goodsoft.catherinebe.dao.RoomDao;
import com.goodsoft.catherinebe.dao.RoomTypeDao;
import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.dto.ConfirmBookingDto;
import com.goodsoft.catherinebe.dto.DeclineBookingDto;
import com.goodsoft.catherinebe.entity.Booking;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingDao bookingDao;
    private final RoomTypeDao roomTypeDao;
    private final BookingStatusDao bookingStatusDao;
    private final RoomDao roomDao;

    @Override
    public void create(BookingDto bookingDto) {
        bookingDao.create(convertToBooking(bookingDto));
    }

    @Override
    public List<BookingDto> getBookings(String statusName) {
        return bookingDao.readByStatus(statusName)
            .stream()
            .map(this::convertToBookingDto)
            .collect(Collectors.toList());
    }

    @Override
    public void confirmBooking(ConfirmBookingDto confirmBookingDto) {
        bookingDao.confirmBooking(confirmBookingDto);
    }

    @Override
    public void declineBooking(DeclineBookingDto declineBookingDto) {
        bookingDao.declineBooking(declineBookingDto);
    }

    @Override
    public Booking convertToBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setUserId(bookingDto.getUserId());
        booking.setPersonCount(bookingDto.getPersonCount());
        booking.setRoomType(roomTypeDao.readByName(bookingDto.getRoomType().toUpperCase()));
        booking.setStayTimeStart(bookingDto.getStayTimeStart());
        booking.setStayTimeEnd(bookingDto.getStayTimeEnd());
        booking.setBookingDate(Timestamp.from(Instant.now()).toLocalDateTime());
        booking.setAdminId(bookingDto.getAdminId());
        booking.setRoom(roomDao.readById(bookingDto.getRoomId()));
        booking.setStatus(bookingStatusDao.readByName(bookingDto.getStatus()));
        return booking;
    }

    @Override
    public BookingDto convertToBookingDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setUserId(booking.getUserId());
        bookingDto.setPersonCount(booking.getPersonCount());
        bookingDto.setRoomType(roomTypeDao.readNameById(booking.getRoomType().getId()));
        bookingDto.setStayTimeStart(booking.getStayTimeStart());
        bookingDto.setStayTimeEnd(booking.getStayTimeEnd());
        bookingDto.setBookingDate(booking.getBookingDate());
        bookingDto.setAdminId(booking.getAdminId());
        Optional.ofNullable(booking.getRoom()).ifPresent(
            room -> bookingDto.setRoomId(room.getId())
        );
        bookingDto.setStatus(bookingStatusDao.readNameById(booking.getStatus().getId()));
        return bookingDto;
    }

}

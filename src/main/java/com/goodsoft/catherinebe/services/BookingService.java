package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.entity.Booking;
import java.util.List;

public interface BookingService {

    void create(BookingDto bookingDto);
    List<BookingDto> getAll();
    Booking convertToBooking(BookingDto bookingDto);

    BookingDto convertToBookingDto(Booking booking);
}

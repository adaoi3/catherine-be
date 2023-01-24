package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.entity.Booking;

public interface BookingService {

    void create(BookingDto bookingDto);

    Booking convertToBooking(BookingDto bookingDto);

}

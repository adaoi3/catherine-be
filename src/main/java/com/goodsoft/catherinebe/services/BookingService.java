package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.dto.ConfirmBookingDto;
import com.goodsoft.catherinebe.dto.DeclineBookingDto;
import com.goodsoft.catherinebe.entity.Booking;
import java.util.List;

public interface BookingService {

    void create(BookingDto bookingDto);

    List<BookingDto> getBookings(String statusName);

    void confirmBooking(ConfirmBookingDto confirmBookingDto);

    void declineBooking(DeclineBookingDto declineBookingDto);

    Booking convertToBooking(BookingDto bookingDto);

    BookingDto convertToBookingDto(Booking booking);

}

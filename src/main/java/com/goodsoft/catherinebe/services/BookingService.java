package com.goodsoft.catherinebe.services;

import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.dto.ConfirmBookingDto;
import com.goodsoft.catherinebe.dto.DeclineBookingDto;
import com.goodsoft.catherinebe.entity.Booking;
import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    void create(BookingDto bookingDto);

    List<BookingDto> getByStatus(String statusName);

    List<BookingDto> getByUserId(Long userId);

    void confirm(ConfirmBookingDto confirmBookingDto);

    void decline(DeclineBookingDto declineBookingDto);

    void delete(Long id);

    Booking convertToBooking(BookingDto bookingDto);

    BookingDto convertToBookingDto(Booking booking);

    void validateBookingPeriod(LocalDate start, LocalDate end);

}

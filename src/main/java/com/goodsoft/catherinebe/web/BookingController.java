package com.goodsoft.catherinebe.web;

import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.services.BookingService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Void> addBooking(@Valid @RequestBody BookingDto bookingDto) {
        bookingService.create(bookingDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> getBookingsByStatus(@RequestParam String statusName) {
        return new ResponseEntity<>(bookingService.getBookings(statusName), HttpStatus.OK);
    }

}

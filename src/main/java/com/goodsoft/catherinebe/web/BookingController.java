package com.goodsoft.catherinebe.web;

import com.goodsoft.catherinebe.config.CustomJwtAuthenticationToken;
import com.goodsoft.catherinebe.dto.BookingDto;
import com.goodsoft.catherinebe.dto.ConfirmBookingDto;
import com.goodsoft.catherinebe.dto.DeclineBookingDto;
import com.goodsoft.catherinebe.services.BookingService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping
    public ResponseEntity<Void> addBooking(@Valid @RequestBody BookingDto bookingDto) {
        bookingService.create(bookingDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<BookingDto>> getBookingsByStatus(@RequestParam String statusName) {
        return new ResponseEntity<>(bookingService.getByStatus(statusName), HttpStatus.OK);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/{userId}")
    public ResponseEntity<List<BookingDto>> getBookingsByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(bookingService.getByUserId(userId), HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/{id}/confirm")
    public ResponseEntity<Void> confirmBooking(@PathVariable Long id,
        @RequestBody ConfirmBookingDto confirmBookingDto,
        CustomJwtAuthenticationToken jwt) {
        confirmBookingDto.setId(id);
        confirmBookingDto.setAdminId(jwt.getId());
        bookingService.confirm(confirmBookingDto);
        SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/{id}/decline")
    public ResponseEntity<Void> declineBooking(@PathVariable Long id, @RequestBody String status,
        CustomJwtAuthenticationToken jwt) {
        DeclineBookingDto declineBookingDto = new DeclineBookingDto();
        declineBookingDto.setId(id);
        declineBookingDto.setAdminId(jwt.getId());
        declineBookingDto.setStatus(status);
        bookingService.decline(declineBookingDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        bookingService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

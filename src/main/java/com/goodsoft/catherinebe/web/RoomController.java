package com.goodsoft.catherinebe.web;

import com.goodsoft.catherinebe.dto.RoomDto;
import com.goodsoft.catherinebe.services.RoomService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/available")
    public ResponseEntity<List<RoomDto>> getAvailableRooms(@RequestParam LocalDate stayTimeStart,
        @RequestParam LocalDate stayTimeEnd,
        @RequestParam String roomType,
        @RequestParam String status
        ) {
        return new ResponseEntity<>(
            roomService.getAvailableRooms(stayTimeStart, stayTimeEnd, roomType, status), HttpStatus.OK);
    }

}

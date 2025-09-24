package com.unibooking.backend.user.controller;

import com.unibooking.backend.user.dto.AppointmentRequestDTO;
import com.unibooking.backend.user.dto.BookingDTO;
import com.unibooking.backend.user.dto.SlotDTO;
import com.unibooking.backend.user.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    // 1. Create a new booking
    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        BookingDTO createdBooking = bookingService.createBooking(bookingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    // 2. Get all bookings for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByUser(@PathVariable String emailId) {
        return ResponseEntity.ok(bookingService.getBookingsByUser(emailId));
    }

    // 3. Get all bookings for a specific provider
    @GetMapping("/provider/{providerId}")
    public ResponseEntity<List<BookingDTO>> getBookingsByProvider(@PathVariable String emailId) {
        return ResponseEntity.ok(bookingService.getBookingsByProvider(emailId));
    }
}

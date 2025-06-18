package com.unibooking.backend.user.controller;

import com.unibooking.backend.user.dto.*;
import com.unibooking.backend.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Get current user profile
    @GetMapping("/currentUser")
    public ResponseEntity<UserDTO> getProfile() {
        return ResponseEntity.ok(userService.getCurrentUserProfile());
    }

    // Search for service providers by name, service, or location
    @GetMapping("/providers/search")
    public ResponseEntity<List<ProviderDTO>> searchProviders(@RequestParam("query") String query) {
        return ResponseEntity.ok(userService.searchProviders(query));
    }

    // View a specific provider's details
    @GetMapping("/providers/{providerId}")
    public ResponseEntity<ProviderDTO> getProviderDetails(@PathVariable Long providerId) {
        return ResponseEntity.ok(userService.getProviderDetails(providerId));
    }

    // View available slots for a provider
    @GetMapping("/providers/{providerId}/slots")
    public ResponseEntity<List<SlotDTO>> getAvailableSlots(@PathVariable Long providerId) {
        return ResponseEntity.ok(userService.getAvailableSlots(providerId));
    }

    // Book an appointment with a provider for a slot
    @PostMapping("/appointments/book")
    public ResponseEntity<BookingDTO> bookAppointment(@RequestBody AppointmentRequestDTO request) {
        return ResponseEntity.ok(userService.bookAppointment(request));
    }

    // View user's appointment bookings
    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDTO>> getMyBookings() {
        return ResponseEntity.ok(userService.getUserBookings());
    }
}
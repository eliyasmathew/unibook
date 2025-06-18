package com.unibooking.backend.user.service;

import com.unibooking.backend.user.dto.*;

import java.util.List;

public interface UserService {

    // Get logged-in user's profile
    UserDTO getCurrentUserProfile();

    // Search service providers by name or service
    List<ProviderDTO> searchProviders(String keyword);

    // View a single service provider’s profile by ID
    ProviderDTO getProviderDetails(Long providerId);

    // View available slots for a provider
    List<SlotDTO> getAvailableSlots(Long providerId);

    // Book a slot with a provider
    BookingDTO bookSlot(Long providerId, Long slotId);

    // View all bookings by current user
    List<BookingDTO> getUserBookings();

    // Cancel a booking (optional)
    void cancelBooking(Long bookingId);

    BookingDTO bookAppointment(AppointmentRequestDTO request);
}

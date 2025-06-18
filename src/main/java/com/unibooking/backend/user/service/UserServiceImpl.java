package com.unibooking.backend.user.service;

import com.unibooking.backend.user.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public UserDTO getCurrentUserProfile() {
        UserDTO user = new UserDTO();
        user.setId(22L);
        user.setName("eli");
        user.setEmail("eliyasmathew@unibook.com");
        return user;
    }

    @Override
    public List<ProviderDTO> searchProviders(String keyword) {
        return List.of();
    }

    @Override
    public ProviderDTO getProviderDetails(Long providerId) {
        return null;
    }

    @Override
    public List<SlotDTO> getAvailableSlots(Long providerId) {
        return List.of();
    }

    @Override
    public BookingDTO bookSlot(Long providerId, Long slotId) {
        return null;
    }

    @Override
    public List<BookingDTO> getUserBookings() {
        return List.of();
    }

    @Override
    public void cancelBooking(Long bookingId) {

    }

    @Override
    public BookingDTO bookAppointment(AppointmentRequestDTO request) {
        return null;
    }
}

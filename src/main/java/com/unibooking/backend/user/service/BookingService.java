package com.unibooking.backend.user.service;

import com.unibooking.backend.user.dto.BookingDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);

    List<BookingDTO> getBookingsByUser(String emailId);

    List<BookingDTO> getBookingsByProvider(Long providerId);
}

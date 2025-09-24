package com.unibooking.backend.user.service;

import com.unibooking.backend.user.dto.AppointmentRequestDTO;
import com.unibooking.backend.user.dto.BookingDTO;
import com.unibooking.backend.user.dto.ProviderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    BookingDTO createBooking(BookingDTO bookingDTO);

    List<BookingDTO> getBookingsByUser(String emailId);

    List<BookingDTO> getBookingsByProvider(String emailId);
}

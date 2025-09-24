package com.unibooking.backend.user.service;

import com.unibooking.backend.user.dto.AppointmentRequestDTO;
import com.unibooking.backend.user.dto.BookingDTO;
import com.unibooking.backend.user.dto.ProviderDTO;
import com.unibooking.backend.user.model.BookingModel;
import com.unibooking.backend.user.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        BookingModel booking = new BookingModel();
        booking.setUserId(bookingDTO.getUserId());
        booking.setProviderId(bookingDTO.getProviderId());
        booking.setSlotId(bookingDTO.getSlotId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setStatus("CONFIRMED");

        BookingModel savedBooking = bookingRepository.save(booking);

        return new BookingDTO(
                savedBooking.getBookingId(),
                savedBooking.getUserId(),
                savedBooking.getProviderId(),
                savedBooking.getSlotId(),
                savedBooking.getBookingDate(),
                savedBooking.getStatus()
        );
    }

    @Override
    public List<BookingDTO> getBookingsByUser(String emailId) {
        return bookingRepository.findByUserId(emailId)
                .stream()
                .map(b -> new BookingDTO(
                        b.getBookingId(),
                        b.getUserId(),
                        b.getProviderId(),
                        b.getSlotId(),
                        b.getBookingDate(),
                        b.getStatus()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> getBookingsByProvider(String emailId) {
        return bookingRepository.findByProviderId(emailId)
                .stream()
                .map(b -> new BookingDTO(
                        b.getBookingId(),
                        b.getUserId(),
                        b.getProviderId(),
                        b.getSlotId(),
                        b.getBookingDate(),
                        b.getStatus()
                ))
                .collect(Collectors.toList());
    }
}

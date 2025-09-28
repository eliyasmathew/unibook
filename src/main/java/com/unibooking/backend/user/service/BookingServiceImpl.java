package com.unibooking.backend.user.service;


import com.unibooking.backend.user.dto.BookingDTO;
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
        booking.setBookingId(bookingDTO.getBookingId());
        booking.setEmailId(bookingDTO.getEmailId());
        booking.setProviderId(bookingDTO.getProviderId());
        booking.setSlotId(bookingDTO.getSlotId());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setBookingStatus("CONFIRMED");

        BookingModel savedBooking = bookingRepository.save(booking);

        return new BookingDTO(
                savedBooking.getBookingId(),
                savedBooking.getEmailId(),
                savedBooking.getProviderId(),
                savedBooking.getSlotId(),
                savedBooking.getBookingDate(),
                savedBooking.getBookingStatus()
        );
    }

    @Override
    public List<BookingDTO> getBookingsByUser(String emailId) {
        return bookingRepository.findByEmailId(emailId)
                .stream()
                .map(b -> new BookingDTO(
                        b.getBookingId(),
                        b.getEmailId(),
                        b.getProviderId(),
                        b.getSlotId(),
                        b.getBookingDate(),
                        b.getBookingStatus()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> getBookingsByProvider(Long providerId) {
        return bookingRepository.findByProviderId(providerId)
                .stream()
                .map(b -> new BookingDTO(
                        b.getBookingId(),
                        b.getEmailId(),
                        b.getProviderId(),
                        b.getSlotId(),
                        b.getBookingDate(),
                        b.getBookingStatus()
                ))
                .collect(Collectors.toList());
    }
}

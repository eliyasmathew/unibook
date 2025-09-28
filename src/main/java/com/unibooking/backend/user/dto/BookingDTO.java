package com.unibooking.backend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private Long bookingId;
    private String emailId;
    private Long providerId;
    private Long slotId;
    private LocalDateTime bookingDate;
    private String bookingStatus;
}

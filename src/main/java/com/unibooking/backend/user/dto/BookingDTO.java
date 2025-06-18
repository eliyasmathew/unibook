package com.unibooking.backend.user.dto;

import lombok.Data;

@Data
public class BookingDTO {
    private Long id;
    private Long providerId;
    private String providerName;
    private SlotDTO slot;
    private String status; // e.g. "CONFIRMED", "CANCELLED"
}
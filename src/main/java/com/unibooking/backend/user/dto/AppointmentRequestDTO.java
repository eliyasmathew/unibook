package com.unibooking.backend.user.dto;

import lombok.Data;

@Data
public class AppointmentRequestDTO {
    private Long providerId;
    private Long slotId;
}

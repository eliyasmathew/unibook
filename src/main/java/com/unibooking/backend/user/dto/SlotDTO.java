package com.unibooking.backend.user.dto;

import lombok.Data;

@Data
public class SlotDTO {
    private Long id;
    private String date;      // e.g. "2025-06-15"
    private String startTime; // e.g. "10:00"
    private String endTime;   // e.g. "10:30"
    private boolean available;
}
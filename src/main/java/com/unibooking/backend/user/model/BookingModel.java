package com.unibooking.backend.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long providerId;

    @Column(nullable = false)
    private Long slotId;

    @Column(nullable = false)
    private LocalDateTime bookingDate;

    private String status; // CONFIRMED, CANCELLED, COMPLETED
}

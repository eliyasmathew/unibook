package com.unibooking.backend.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProviderDTO {
    private Long providerId;
    private String providerName; // Name of service (e.g., Haircut, Consultation)
    private String providerEmail;
    private String providerPassword;
    private String providerPhone;
    private String providerBusinessName;
    private String providerCategory;
    private String providerAddress;
    private String providerLocation;
    private String providerDescription;
    private LocalDateTime providerCreatedAt;
}
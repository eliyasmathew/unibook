package com.unibooking.backend.user.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

    @Column(nullable = false)
    private String providerName; // Name of service (e.g., Haircut, Consultation)

    private String providerEmail;

    @Column(nullable = false)
    private String providerPassword;

    private String providerPhone;

    private String providerBusinessName;

    private String providerCategory;

    private String providerAddress;

    private String providerLocation;

    private String providerDescription;

    private String providerCreatedAt;




}
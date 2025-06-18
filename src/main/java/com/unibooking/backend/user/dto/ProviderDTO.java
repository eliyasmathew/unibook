package com.unibooking.backend.user.dto;

import lombok.Data;

@Data
public class ProviderDTO {
    private Long id;
    private String name;
    private String category; // e.g. Hospital, Car Wash
    private String location;
    private String description;
    private Double rating; // average rating
}
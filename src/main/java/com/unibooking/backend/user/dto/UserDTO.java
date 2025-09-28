package com.unibooking.backend.user.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userPassword;
    private LocalDateTime createdAt;
}
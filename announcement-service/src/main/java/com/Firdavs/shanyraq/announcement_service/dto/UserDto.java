package com.Firdavs.shanyraq.announcement_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private boolean isVerified;
}
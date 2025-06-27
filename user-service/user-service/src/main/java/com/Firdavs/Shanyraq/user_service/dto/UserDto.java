package com.Firdavs.Shanyraq.user_service.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

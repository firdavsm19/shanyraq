package com.Firdavs.Shanyraq.user_service.dto;

import java.time.LocalDate;

import com.Firdavs.Shanyraq.user_service.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileDto {
    private UserDto user;
    private LocalDate birthDate;
    private Gender gender;
    private String profilePhoto;
    private String coverLetter;
    private boolean isSurveyCompleted;
}

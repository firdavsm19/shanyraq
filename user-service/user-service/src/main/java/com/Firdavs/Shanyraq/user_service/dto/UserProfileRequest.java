package com.Firdavs.Shanyraq.user_service.dto;

import com.Firdavs.Shanyraq.user_service.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileRequest {

    private Gender gender;
    private String coverLetter;
    private LocalDate birthdate;

}

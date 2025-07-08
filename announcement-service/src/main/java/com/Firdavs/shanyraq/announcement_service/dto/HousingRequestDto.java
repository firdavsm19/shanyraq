package com.Firdavs.shanyraq.announcement_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HousingRequestDto {

    @NotBlank
    private String title;

    @NotBlank
    private String contactName;

    @NotNull
    private Long userId;

    @NotNull
    private LocalDateTime moveInDate;

    private String aboutMe;

    @Size(max = 255)
    private String occupation;

    private Integer monthlyIncome;

    private boolean hasPets;

    private boolean isStudent;

    private boolean isSmoker;

    @NotNull
    @Valid
    private HousingPreferencesDto housingPreferences;

    private Integer maxMonthlyRent;

    private Integer maxDeposit;
}

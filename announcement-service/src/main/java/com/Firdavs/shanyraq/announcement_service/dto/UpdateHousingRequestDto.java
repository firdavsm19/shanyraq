package com.Firdavs.shanyraq.announcement_service.dto;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateHousingRequestDto {

    private String title;

    private String contactName;

    private LocalDateTime moveInDate;

    private String aboutMe;

    private String occupation;

    private Integer monthlyIncome;

    private Boolean hasPets;

    private Boolean isStudent;

    private Boolean isSmoker;

    @Valid
    private HousingPreferencesDto housingPreferences;

    private Integer maxMonthlyRent;

    private Integer maxDeposit;
}

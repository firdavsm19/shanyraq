package com.Firdavs.shanyraq.announcement_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HousingRequestResponse {

    private Long id;

    private String title;

    private String contactName;

    private Long userId;

    private LocalDateTime moveInDate;

    private String aboutMe;

    private String occupation;

    private Integer monthlyIncome;

    private boolean hasPets;

    private boolean isStudent;

    private boolean isSmoker;

    private HousingPreferencesDto housingPreferences;

    private Integer maxMonthlyRent;

    private Integer maxDeposit;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

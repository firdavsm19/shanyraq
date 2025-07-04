package com.Firdavs.shanyraq.announcement_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PreferencesDto {
    private Long id;

    @NotNull(message = "How many people live is required")
    private Integer howManyPeopleLive;

    @NotNull(message = "Accomodating people is required")
    @Min(value = 1, message = "Accomodating people must be at least 1")
    private Integer accomodatingPeople;

    @NotNull(message = "Min age is required")
    @Min(value = 18, message = "Min age must be at least 18")
    private Integer minAge;

    @NotNull(message = "Max age is required")
    @Min(value = 18, message = "Max age must be at least 18")
    private Integer maxAge;
    
    @NotNull(message = "Do you live in this house is required")
    private boolean doYouLiveInThisHouse;

    private boolean arePetsAllowed;
    private boolean intendedForStudents;
    private boolean areBadHabitsAllowed;
    private boolean forAlongTime;
    private boolean consideringOnlyNPeople;
}

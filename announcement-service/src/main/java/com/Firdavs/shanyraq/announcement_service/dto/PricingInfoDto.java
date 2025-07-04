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
public class PricingInfoDto {
    private Long id;

    @NotNull(message = "Cost is required")
    @Min(value = 0, message = "Cost must be at least 0")
    private Integer cost;

    @NotNull(message = "Is deposit required is required")
    private boolean isDepositRequired;

    @NotNull(message = "Deposit is required")
    @Min(value = 0, message = "Deposit must be at least 0")
    private Integer deposit;

    @NotNull(message = "Is communal service included is required")
    private boolean isCommunalServiceIncluded;

    @Min(value = 0, message = "Min amount of communal service must be at least 0")
    private Integer minAmountOfCommunalService;

    @Min(value = 0, message = "Max amount of communal service must be at least 0")
    private Integer maxAmountOfCommunalService;
    
}

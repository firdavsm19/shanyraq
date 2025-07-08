package com.Firdavs.shanyraq.announcement_service.dto;

import com.Firdavs.shanyraq.announcement_service.model.PaymentFrequency;
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

    @NotNull(message = "Monthly Rent is required")
    @Min(value = 0, message = "Rent must be at least 0")
    private Integer monthlyRent;

    @NotNull(message = "Deposit is required")
    @Min(value = 0, message = "Deposit must be at least 0")
    private Integer depositAmount;

    @NotNull(message = "Is communal service included is required")
    private boolean isUtilitiesIncluded = false;

    private PaymentFrequency paymentFrequency;
    
}

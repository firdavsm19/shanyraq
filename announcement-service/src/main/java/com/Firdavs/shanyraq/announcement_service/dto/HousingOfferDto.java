package com.Firdavs.shanyraq.announcement_service.dto;

import com.Firdavs.shanyraq.announcement_service.model.TenantPreferences;
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
public class HousingOfferDto {

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title should be less than 255 characters")
    private String title;

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name should be less than 255 characters")
    private String contactName;

    @NotNull(message = "Available From is required")
    @FutureOrPresent
    private LocalDateTime availableFrom;

    @NotNull
    @Future
    private LocalDateTime availableUntil;

    @Size(max = 5000)
    private String propertyDescription;

    @NotNull
    @Valid
    private ApartmentInfoDto apartmentInfo;

    @NotNull
    @Valid
    private LocationInfoDto locationInfo;

    @NotNull
    @Valid
    private TenantPreferencesDto tenantPreferences;

    @NotNull
    @Valid
    private PricingInfoDto pricingInfo;
}

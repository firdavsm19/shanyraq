package com.Firdavs.shanyraq.announcement_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateHousingOfferDto {

    private String title;

    private String contactName;

    private LocalDateTime availableFrom;

    private LocalDateTime availableUntil;

    private String propertyDescription;

    private ApartmentInfoDto apartmentInfoDto;

    private LocationInfoDto locationInfoDto;

    private TenantPreferencesDto tenantPreferencesDto;

    private PricingInfoDto pricingInfoDto;
}


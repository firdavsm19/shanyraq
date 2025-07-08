package com.Firdavs.shanyraq.announcement_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HousingOfferResponse {

    private Long id;
    private Long userId;

    private String title;
    private String contactName;
    private boolean isArchived;
    private boolean isDraft;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private LocalDateTime availableFrom;
    private LocalDateTime availableUntil;
    private String propertyDescription;
    private ApartmentInfoDto apartmentInfo;
    private LocationInfoDto locationInfo;
    private TenantPreferencesDto tenantPreferences;
    private PricingInfoDto pricingInfo;
}

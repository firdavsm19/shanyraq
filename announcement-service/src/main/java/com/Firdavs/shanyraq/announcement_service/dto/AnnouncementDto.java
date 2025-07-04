package com.Firdavs.shanyraq.announcement_service.dto;

import java.time.LocalDateTime;

import javax.management.relation.Role;

import com.Firdavs.shanyraq.announcement_service.model.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDto {
    private Long id;
    private Long userId;
    private String title;
    private Role role;
    private Gender selectedGender;
    private LocalDateTime arrivalDate;
    private String ownersName;
    private String ownersPhoneNumber;
    private String photo;
    private boolean isArchived;
    private boolean isDeleted;
    private boolean isDraft;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private LocationInfoDto locationInfo;
    private ApartmentInfoDto apartmentInfo;
    private PreferencesDto preferences;
    private PricingInfoDto pricingInfo;

    
}
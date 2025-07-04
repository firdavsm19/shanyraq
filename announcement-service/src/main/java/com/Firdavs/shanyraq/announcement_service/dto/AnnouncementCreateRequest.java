package com.Firdavs.shanyraq.announcement_service.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.Firdavs.shanyraq.announcement_service.model.Gender;
import com.Firdavs.shanyraq.announcement_service.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementCreateRequest {

    @NotNull(message = "Role is required")
    private Role role;

    @NotBlank(message = "Title is required")
    @Size(min = 10, max = 255, message = "Title must be between 10 and 255 characters")
    private String title;

    @NotNull(message = "Gender is required")
    private Gender selectedGender;

    @NotNull(message = "Arrival date is required")
    private LocalDateTime arrivalDate;

    @NotNull(message = "Owners name is required")
    @Size(min = 2, max = 255)
    private String ownersName;

    @NotNull(message = "Owners phone number is required")
    @Size(min = 10, max = 15, message = "Owners phone number must be between 10 and 15 characters")
    private String ownersPhoneNumber;

    @NotNull(message = "Photo is required")
    @Size(min = 10, max = 255, message = "Photo must be between 10 and 255 characters")
    private String photo;

    @NotNull(message = "Location info is required")
    private LocationInfoDto locationInfo;

    @NotNull(message = "Apartment info is required")
    private ApartmentInfoDto apartmentInfo;

    @NotNull(message = "Preferences is required")
    private PreferencesDto preferences;

    @NotNull(message = "Pricing info is required")
    private PricingInfoDto pricingInfo;

}


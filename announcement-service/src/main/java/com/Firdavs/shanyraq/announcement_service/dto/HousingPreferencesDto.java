package com.Firdavs.shanyraq.announcement_service.dto;


import com.Firdavs.shanyraq.announcement_service.model.Amenity;
import com.Firdavs.shanyraq.announcement_service.model.TypeOfHousing;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HousingPreferencesDto {

    private TypeOfHousing preferredHousingType;
    @Min(value = 1, message = "At least one room")
    private Integer minRooms;

    @Min(value = 1, message = "At least one room")
    private Integer maxRooms;

    private Set<Amenity> preferredAmenities;
}

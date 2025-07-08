package com.Firdavs.shanyraq.announcement_service.dto;

import com.Firdavs.shanyraq.announcement_service.model.Amenity;
import jakarta.validation.constraints.*;

import com.Firdavs.shanyraq.announcement_service.model.TypeOfHousing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentInfoDto {

    private Long id;

    @NotNull(message = "Quantity of rooms is required")
    @Min(1)
    @Max(9)
    private Integer quantityOfRooms;

    @NotNull(message = "Max floor building is required")
    private Integer maxFloorBuilding;

    @NotNull(message = "Area of apartment is required")
    @Min(value = 10, message = "Area of apartment must be at least 10 square meters")
    private Integer areaOfApartment;    

    @NotNull(message = "Type of housing is required")
    private TypeOfHousing typeOfHousing;

    private Set<Amenity> amenities;

}

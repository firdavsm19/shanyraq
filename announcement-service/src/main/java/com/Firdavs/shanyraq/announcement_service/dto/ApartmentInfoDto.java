package com.Firdavs.shanyraq.announcement_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.Firdavs.shanyraq.announcement_service.model.TypeOfHousing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentInfoDto {

    private Long id;

    @NotNull(message = "Quantity of rooms is required")
    @Pattern(regexp = "^[1-9]$", message = "Quantity of rooms must be a number between 1 and 9")
    private String quantityOfRooms;

    @NotNull(message = "Number of floors is required")
    @Pattern(regexp = "^[1-9]$", message = "Number of floors must be a number between 1 and 9")
    private Integer numberOfFloors;

    @NotNull(message = "Max floor building is required")
    private Integer maxFloorBuilding;

    @NotNull(message = "Area of apartment is required")
    @Min(value = 10, message = "Area of apartment must be at least 10 square meters")
    private Integer areaOfApartment;    

    @NotNull(message = "Type of housing is required")
    private TypeOfHousing typeOfHousing;

    @NotNull(message = "Apartments info is required")
    @Size(min = 10, max = 255, message = "Apartments info must be between 10 and 255 characters")
    private String apartmentsInfo;

}

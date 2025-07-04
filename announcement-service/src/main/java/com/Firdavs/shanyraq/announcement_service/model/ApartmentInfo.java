package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "apartment_info")
@Builder
public class ApartmentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity_of_rooms", nullable = false)
    private String quantityOfRooms;

    @Column(name = "number_of_floors")
    @Min(1)
    @Max(100)
    private Integer numberOfFloors;

    @Column(name = "max_floor_building")
    @Min(1)
    @Max(100)
    private Integer maxFloorBuilding;

    @Column(name = "area_of_apartment")
    @Min(1)
    @Max(1000)
    private Integer areaOfApartment;

    @Column(name = "type_of_housing", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeOfHousing typeOfHousing;

    @Column(name = "apartments_info", length = 5000)
    @Size(max = 5000)
    private String apartmentsInfo;

    @Column(name = "is_furnished", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isFurnished;

    @Column(name = "has_parking", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean hasParking;

    @Column(name = "has_internet", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean hasInternet;

    @Column(name = "has_air_conditioning", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean hasAirConditioning;

    @Column(name = "has_balcony", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean hasBalcony;
}
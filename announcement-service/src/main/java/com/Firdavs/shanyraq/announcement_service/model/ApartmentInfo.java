package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.util.Set;

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
    private Integer quantityOfRooms;

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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "aparment_amenities", joinColumns = @JoinColumn(name = "apartment_info_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "amenity")
    private Set<Amenity> amenities;
}
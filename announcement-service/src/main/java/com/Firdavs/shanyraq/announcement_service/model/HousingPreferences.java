package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "housing_preferences")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HousingPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preferred_housing_type")
    @Enumerated(EnumType.STRING)
    private TypeOfHousing preferredHousingType;

    @Column(name = "min_rooms")
    private Integer minRooms;

    @Column(name = "max_rooms")
    private Integer maxRooms;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "housing_preferences_amenities", joinColumns = @JoinColumn(name = "preference_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "amenity")
    private Set<Amenity> prefreredAmenities;
}
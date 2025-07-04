package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "min_area")
    private Integer minArea;

    @Column(name = "max_area")
    private Integer maxArea;

    @Column(name = "prefer_furnished", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean preferFurnished;

    @Column(name = "need_parking", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean needParking;

    @Column(name = "need_internet", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean needInternet;

    @Column(name = "prefer_quiet_area", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean preferQuietArea;

    @Column(name = "prefer_ground_floor", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean preferGroundFloor;

    @Column(name = "need_air_conditioning", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean needAirConditioning;

    @Column(name = "need_balcony", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean needBalcony;
}
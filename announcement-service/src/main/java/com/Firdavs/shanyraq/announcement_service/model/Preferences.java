package com.Firdavs.shanyraq.announcement_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Data
@NoArgsConstructor
@AllArgsConstructor 
@Entity
@Table(name = "preferences")
@Builder
public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "how_many_people_live")
    @Min(1)
    @Max(10)
    private Integer howManyPeopleLive;

    @Column(name = "accomodating_people", nullable = false)
    @Min(1)
    @Max(10)
    private Integer accomodatingPeople;

    @Column(name = "min_age")
    @Min(18)
    @Max(100)
    private Integer minAge;

    @Column(name = "max_age")
    @Min(18)
    @Max(100)
    private Integer maxAge;

    @Column(name = "livin_in_this_house", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean doYouLiveInThisHouse;
    
    @Column(name = "are_pets_allowed", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean arePetsAllowed;

    @Column(name = "intended_for_students", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean intendedForStudents;

    @Column(name = "are_bad_habits_allowed", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean areBadHabitsAllowed;

    @Column(name = "for_along_time", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean forAlongTime;

    @Column(name = "considering_only_n_people", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean consideringOnlyNPeople;

}

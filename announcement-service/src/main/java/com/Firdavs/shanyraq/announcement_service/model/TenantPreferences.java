package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "tenant_preferences")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "min_age")
    @Min(18)
    @Max(100)
    private Integer minAge;

    @Column(name = "max_age")
    @Min(18)
    @Max(100)
    private Integer maxAge;

    @Column(name = "max_occupants")
    @Min(1)
    @Max(10)
    private Integer maxOccupants;

    private boolean petsAllowed = false;

    private boolean smokingAllowed = false;

    private boolean requiresReferences = false;

    private boolean requiresIncomeProof = false;
}
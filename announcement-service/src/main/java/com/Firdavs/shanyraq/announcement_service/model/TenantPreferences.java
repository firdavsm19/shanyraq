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

    @Column(name = "preferred_gender")
    @Enumerated(EnumType.STRING)
    private Gender preferredGender;

    @Column(name = "max_occupants")
    @Min(1)
    @Max(10)
    private Integer maxOccupants;

    @Column(name = "pets_allowed", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean petsAllowed;

    @Column(name = "students_allowed", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean studentsAllowed;

    @Column(name = "smoking_allowed", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean smokingAllowed;

    @Column(name = "requires_references", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean requiresReferences;

    @Column(name = "requires_income_proof", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean requiresIncomeProof;

    @Column(name = "minimum_income")
    private Integer minimumIncome;
}
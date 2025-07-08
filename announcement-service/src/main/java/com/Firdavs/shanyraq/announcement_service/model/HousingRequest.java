package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class HousingRequest extends BaseAnnouncement {

    @Column(name = "move_in_date", nullable = false)
    private LocalDateTime moveInDate;

    @Lob
    private String aboutMe;

    @Column(name = "occupation", length = 255)
    private String occupation;

    @Column(name = "monthly_income")
    private Integer monthlyIncome;

    @Column(name = "has_pets", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean hasPets;

    @Column(name = "is_student", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isStudent;

    @Column(name = "is_smoker", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isSmoker;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "housing_preferences_id")
    private HousingPreferences housingPreferences;

    private Integer maxMonthlyRent;

    private Integer maxDeposit;
}

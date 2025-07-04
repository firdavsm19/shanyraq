package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HousingRequest extends BaseAnnouncement {

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "move_in_date", nullable = false)
    private LocalDateTime moveInDate;

    @Column(name = "move_out_date")
    private LocalDateTime moveOutDate;

    @Column(name = "about_me", length = 5000)
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

    @Column(name = "references", length = 1000)
    private String references;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "housing_preferences_id")
    private HousingPreferences housingPreferences;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "budget_info_id")
    private BudgetInfo budgetInfo;
}

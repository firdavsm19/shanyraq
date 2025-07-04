package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "housing_applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HousingApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "housing_offer_id", nullable = false)
    private HousingOffer housingOffer;

    @Column(name = "applicant_user_id", nullable = false)
    private Long applicantUserId;

    @Column(name = "applicant_name", nullable = false, length = 255)
    private String applicantName;

    @Column(name = "applicant_phone_numbers", columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> applicantPhoneNumbers;

    @Column(name = "applicant_age")
    private Integer applicantAge;

    @Column(name = "preferred_move_in_date")
    private LocalDate preferredMoveInDate;

    @Column(name = "application_message", length = 2000)
    private String applicationMessage;

    @Column(name = "monthly_income")
    private Integer monthlyIncome;

    @Column(name = "occupation", length = 255)
    private String occupation;

    @Column(name = "application_status")
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;

    @Column(name = "applied_at")
    private LocalDateTime appliedAt;

    @Column(name = "reviewed_at")
    private LocalDateTime reviewedAt;

    @Column(name = "response_message", length = 1000)
    private String responseMessage;
}
package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "budget_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "max_monthly_rent", nullable = false)
    @Min(1000)
    private Integer maxMonthlyRent;

    @Column(name = "max_deposit")
    @Min(0)
    private Integer maxDeposit;

    @Column(name = "max_utilities")
    @Min(0)
    private Integer maxUtilities;

    @Column(name = "can_pay_deposit", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean canPayDeposit;

    @Column(name = "can_pay_advance", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean canPayAdvance;

    @Column(name = "max_advance_months")
    private Integer maxAdvanceMonths;

    @Column(name = "preferred_payment_frequency")
    @Enumerated(EnumType.STRING)
    private PaymentFrequency preferredPaymentFrequency;
}
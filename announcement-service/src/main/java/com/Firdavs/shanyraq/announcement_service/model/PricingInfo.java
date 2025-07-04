package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pricing_info")
@Builder
public class PricingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monthly_rent", nullable = false)
    @Min(1000)
    @Max(1000000000)
    private Integer monthlyRent;

    @Column(name = "is_deposit_required", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isDepositRequired;

    @Column(name = "deposit_amount")
    private Integer depositAmount;

    @Column(name = "is_utilities_included", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isUtilitiesIncluded;

    @Column(name = "estimated_utilities_cost")
    private Integer estimatedUtilitiesCost;

    @Column(name = "payment_frequency")
    @Enumerated(EnumType.STRING)
    private PaymentFrequency paymentFrequency;

    @Column(name = "advance_payment_months")
    private Integer advancePaymentMonths;
}
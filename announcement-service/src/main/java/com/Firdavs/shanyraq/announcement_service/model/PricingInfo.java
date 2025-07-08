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
    private Integer monthlyRent;

    @Column(name = "deposit_amount")
    private Integer depositAmount;

    private boolean isUtilitiesIncluded = false;

    @Column(name = "payment_frequency")
    @Enumerated(EnumType.STRING)
    private PaymentFrequency paymentFrequency;

}
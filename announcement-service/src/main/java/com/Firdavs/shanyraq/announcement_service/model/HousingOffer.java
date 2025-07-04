package com.Firdavs.shanyraq.announcement_service.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HousingOffer extends BaseAnnouncement {

    @Column(name = "available_from", nullable = false)
    private LocalDateTime availableFrom;

    @Column(name = "available_until", nullable = false)
    private LocalDateTime availableUntil;

    @Column(name = "property_description", length = 5000)
    private String propertyDescription;

    @Column(name = "is_owner_occupied", columnDefinition = "boolean default false")
    private boolean isOwnerOccupied;

    @Column(name = "immediate_availability", columnDefinition = "boolean default false")
    private boolean immediateAvailability;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_info_id")
    private ApartmentInfo apartmentInfo;

    private String photo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_info_id")
    private LocationInfo locationInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenant_preferences_id")
    private TenantPreferences tenantPreferences;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pricing_info_id")
    private PricingInfo pricingInfo;

    @OneToMany(mappedBy = "housingOffer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HousingApplication> applications = new ArrayList<>();

}

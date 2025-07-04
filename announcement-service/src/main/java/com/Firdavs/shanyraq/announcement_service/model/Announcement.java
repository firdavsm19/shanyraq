package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.Size;

@Entity
@Data
@Table(name = "announcements")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name ="gender", nullable = false)
    private Gender selectedGender;

    @Column(name = "arrival_date", nullable = false)
    private LocalDateTime arrivalDate;

    @Column(name = "owners_name", length = 255)
    @Size(min = 2, max = 255)
    private String ownersName;

    private String ownersPhoneNumber;

    private String photo;

    @Column(name = "is_archived", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isArchived;

    @Column(name = "is_deleted", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isDeleted;

    @Column(name = "is_draft", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean isDraft;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_info_id")
    private LocationInfo locationInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apartment_info_id")
    private ApartmentInfo apartmentInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preferences_id")
    private Preferences preferences;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pricing_info_id")
    private PricingInfo pricingInfo;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;




}

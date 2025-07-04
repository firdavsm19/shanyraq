package com.Firdavs.shanyraq.announcement_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class BaseAnnouncement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "contact_name", nullable = false, length = 255)
    private String contactName;

    @Column(name = "contact_phone_number", nullable = false, length = 255)
    private String contactPhoneNumber;

    // photo for houseoffer

    @Column(name = "is_archived", columnDefinition = "boolean default false")
    private boolean isArchived;

    @Column(name = "is_draft", columnDefinition = "boolean default true")
    private boolean isDraft;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

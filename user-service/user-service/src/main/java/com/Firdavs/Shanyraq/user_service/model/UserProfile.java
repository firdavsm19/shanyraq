package com.Firdavs.Shanyraq.user_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Index;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_profiles", indexes = {
    @Index(name = "idx_user_id", columnList = "user_id")
})
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 500)
    @Size(max = 500, message = "URL must not exceed 500 characters")
    @Pattern(
        regexp = "^(https?://)?[\\w.-]+(?:\\.[\\w\\.-]+)+[/#?]?.*$",
        message = "Must be a valid URL"
    )
    private String profilePhoto;

    private String coverLetter;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isSurveyCompleted;
}

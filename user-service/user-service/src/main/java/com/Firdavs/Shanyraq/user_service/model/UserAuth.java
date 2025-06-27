package com.Firdavs.Shanyraq.user_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Index;
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_auth", indexes = {
    @Index(name = "idx_user_id", columnList = "user_id"),
    @Index(name = "idx_google_id", columnList = "google_id")
})
@Builder
public class UserAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String password;

    @Column(length = 6)
    private String confirmationCode;

    @Column(length = 255)
    private String googleId;

    @Column(length = 255)
    private String pendingInvitationToken;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isVerified;
}

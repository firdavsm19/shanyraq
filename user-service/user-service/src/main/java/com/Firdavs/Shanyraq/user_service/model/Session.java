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
import lombok.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessions", indexes = {
    @Index(name = "idx_user_id", columnList = "user_id"), 
    @Index(name = "idx_access_token", columnList = "access_token"),
    @Index(name = "idx_expires_at", columnList = "expires_at")
})
@Builder
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 255, unique = true)
    private String accessToken;

    @Column(nullable = false, length = 255, unique = true)
    private String refreshToken;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private LocalDateTime lastActivityAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.expiresAt = LocalDateTime.now().plusDays(30);
        this.lastActivityAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        this.lastActivityAt = LocalDateTime.now();
    }
}

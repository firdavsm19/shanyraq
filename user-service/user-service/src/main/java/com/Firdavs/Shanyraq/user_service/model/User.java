package com.Firdavs.Shanyraq.user_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import jakarta.validation.constraints.Email;
import jakarta.persistence.Index;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "users",
indexes = {
    @Index(name = "idx_email", columnList = "email"), 
    @Index(name = "idx_phone", columnList = "phoneNumber"),
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(length = 50)
    @Size(min = 2, max = 50)
    private String lastName;

    @Column(nullable = false, unique = true, length = 255)
    @Size(max = 255, message = "Email must not exceed 255 characters")
    @Email(message = "Invalid email address")
    private String email;

    @Column(nullable = false, unique = true, length = 12)
    @Pattern(regexp = "\\+7\\d{10}", message = "Phone must match pattern +7XXXXXXXXXX")
    private String phoneNumber;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserProfile userProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private UserAuth userAuth;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Session> sessions;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}

package com.Firdavs.shanyraq.group_service.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "group_member", indexes = {
    @Index(name = "idx_groupId", columnList = "groupId"),
        @Index(name = "idx_userId", columnList = "userId")

})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long groupId;

    private Long userId;

    @Column(nullable = false)
    @Size(max = 100)
    private String name;

    @Min(18)
    private Integer age;

    private String phoneNumber;

    private String email;

    private Status status;

    private Role role;

    @Lob
    private String coverLetter;

    private LocalDateTime joinedAt;

    private LocalDateTime appliedAt;

}

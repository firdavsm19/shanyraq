package com.Firdavs.shanyraq.announcement_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resident_data")
@Builder
public class ResidentData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "announcement_id", nullable = false)
    private Long announcementId;

    @Column(name = "name", nullable = false, length = 255)
    @Size(min = 2, max = 255)
    private String name;
    
    @Column(name = "phone_numbers", columnDefinition = "json")
    @JdbcTypeCode(SqlTypes.JSON)
    private List<String> phoneNumbers;

    @Column(name = "is_survey_completed", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isSurveyCompleted;

    private Long userId;

    private Integer age;

    private LocalDate moveInDate;
}

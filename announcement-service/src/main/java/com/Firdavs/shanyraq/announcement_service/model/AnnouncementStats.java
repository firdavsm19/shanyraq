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
import jakarta.persistence.Column;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "anouncement_stats")
public class AnnouncementStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long announcementId;

    @Column(name = "views_count", columnDefinition = "INT DEFAULT 0")
    private Integer viewsCount;

    @Column(name = "unique_views_count", columnDefinition = "INT DEFAULT 0")
    private Integer uniqueViewsCount;

    @Column(name = "responses_count", columnDefinition = "INT DEFAULT 0")
    private Integer responsesCount;

    @Column(name = "last_viewed_at")
    private LocalDateTime lastViewedAt;
    
    @Column(name = "conversion_rate", columnDefinition = "DECIMAL(10,2) DEFAULT 0.00")
    private BigDecimal conversionRate; 

    @Column(name = "average_view_duration", columnDefinition = "INT DEFAULT 0")
    private Integer averageViewDuration;
}

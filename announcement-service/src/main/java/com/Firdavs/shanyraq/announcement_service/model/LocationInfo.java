package com.Firdavs.shanyraq.announcement_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "location_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region_id", nullable = false)
    private Long regionId;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "address", nullable = false, length = 500)
    @Size(min = 10, max = 500)
    private String address;

    @Column(name = "lat", nullable = false)
    private BigDecimal lat;

    @Column(name = "lon", nullable = false)
    private BigDecimal lon;
}
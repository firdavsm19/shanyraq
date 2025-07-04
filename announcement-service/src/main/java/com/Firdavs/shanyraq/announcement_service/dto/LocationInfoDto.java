package com.Firdavs.shanyraq.announcement_service.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationInfoDto {

    private Long id;

    @NotNull(message = "Region is required")
    @Positive(message = "Region must be a positive number")
    private Long regionId;

    @Positive(message = "District must be a positive number")
    private Long districtId;

    @Positive(message = "Micro district must be a positive number")
    private Long microDistrictId;

    @NotNull(message = "Address is required")
    @Size(min = 10, max = 255, message = "Address must be between 10 and 255 characters")
    private String address;

    private BigDecimal coordsX;
    private BigDecimal coordsY;
    
}

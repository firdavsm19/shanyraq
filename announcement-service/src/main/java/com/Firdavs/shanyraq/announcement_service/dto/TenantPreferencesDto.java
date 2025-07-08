package com.Firdavs.shanyraq.announcement_service.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TenantPreferencesDto {

    @Min(18)
    private Integer minAge;

    @Min(18)
    private Integer maxAge;

    @Min(1)
    private Integer maxOccupants;

    private boolean petsAllowed = false;
    private boolean smokingAllowed = false;
    private boolean requiresReferences = false;
    private boolean requiresIncomeProof = false;
}

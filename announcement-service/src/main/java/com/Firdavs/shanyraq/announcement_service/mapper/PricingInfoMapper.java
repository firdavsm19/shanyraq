package com.Firdavs.shanyraq.announcement_service.mapper;

import com.Firdavs.shanyraq.announcement_service.dto.PricingInfoDto;
import com.Firdavs.shanyraq.announcement_service.dto.TenantPreferencesDto;
import com.Firdavs.shanyraq.announcement_service.model.PricingInfo;
import com.Firdavs.shanyraq.announcement_service.model.TenantPreferences;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricingInfoMapper {
    PricingInfo toEntity(PricingInfoDto dto);
    PricingInfoDto toDto(PricingInfo entity);
}


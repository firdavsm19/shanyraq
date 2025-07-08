package com.Firdavs.shanyraq.announcement_service.mapper;

import com.Firdavs.shanyraq.announcement_service.dto.TenantPreferencesDto;
import com.Firdavs.shanyraq.announcement_service.model.TenantPreferences;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TenantPreferencesMapper {
    TenantPreferences toEntity(TenantPreferencesDto dto);
    TenantPreferencesDto toDto(TenantPreferences entity);
}


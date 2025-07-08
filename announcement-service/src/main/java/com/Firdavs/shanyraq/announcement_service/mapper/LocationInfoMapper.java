package com.Firdavs.shanyraq.announcement_service.mapper;

import com.Firdavs.shanyraq.announcement_service.dto.LocationInfoDto;
import com.Firdavs.shanyraq.announcement_service.model.LocationInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationInfoMapper {
    LocationInfo toEntity(LocationInfoDto dto);
    LocationInfoDto toDto(LocationInfo entity);
}

package com.Firdavs.shanyraq.announcement_service.mapper;

import com.Firdavs.shanyraq.announcement_service.dto.ApartmentInfoDto;
import com.Firdavs.shanyraq.announcement_service.model.ApartmentInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApartmentInfoMapper {
    ApartmentInfo toEntity(ApartmentInfoDto dto);
    ApartmentInfoDto toDto(ApartmentInfo entity);
}

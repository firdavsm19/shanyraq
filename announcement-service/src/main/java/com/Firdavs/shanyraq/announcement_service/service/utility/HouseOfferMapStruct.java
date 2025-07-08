package com.Firdavs.shanyraq.announcement_service.service.utility;

import com.Firdavs.shanyraq.announcement_service.dto.*;
import com.Firdavs.shanyraq.announcement_service.mapper.ApartmentInfoMapper;
import com.Firdavs.shanyraq.announcement_service.mapper.LocationInfoMapper;
import com.Firdavs.shanyraq.announcement_service.mapper.PricingInfoMapper;
import com.Firdavs.shanyraq.announcement_service.mapper.TenantPreferencesMapper;
import com.Firdavs.shanyraq.announcement_service.model.HousingOffer;
import com.Firdavs.shanyraq.announcement_service.model.HousingRequest;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        uses = {
                ApartmentInfoMapper.class,
                LocationInfoMapper.class,
                PricingInfoMapper.class,
                TenantPreferencesMapper.class
        }
)
public interface HouseOfferMapStruct {

    // MapStruct maps all fields from dto, but not userId
    @Mapping(target = "userId", expression = "java(userId)")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    HousingOffer toEntity(HousingOfferDto dto, @Context Long userId);

    HousingOfferResponse toResponse(HousingOffer entity);

    @Mapping(target = "userId", expression = "java(userId)")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    HousingRequest toEntity(HousingRequestDto dto, @Context Long userId);

    HousingRequestResponse toResponse(HousingRequest entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(UpdateHousingOfferDto dto, @MappingTarget HousingOffer entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(UpdateHousingRequestDto dto, @MappingTarget HousingRequest entity);
}



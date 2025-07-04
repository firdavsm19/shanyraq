package com.Firdavs.shanyraq.announcement_service.service;

import org.springframework.stereotype.Service;

import com.Firdavs.shanyraq.announcement_service.dto.AnnouncementCreateRequest;
import com.Firdavs.shanyraq.announcement_service.dto.ApartmentInfoDto;
import com.Firdavs.shanyraq.announcement_service.dto.LocationInfoDto;
import com.Firdavs.shanyraq.announcement_service.dto.PreferencesDto;
import com.Firdavs.shanyraq.announcement_service.dto.PricingInfoDto;
import com.Firdavs.shanyraq.announcement_service.exception.ValidationException;
    

@Service
public class AnnouncementValidationService {
 
    public void validateAnnouncement(AnnouncementCreateRequest announcementCreateRequest){
        validateApartmentInfo(announcementCreateRequest.getApartmentInfo());
        validateLocationInfo(announcementCreateRequest.getLocationInfo());
        validatePreferences(announcementCreateRequest.getPreferences());
        validatePricingInfo(announcementCreateRequest.getPricingInfo());
        validateBusinessRules(announcementCreateRequest);
    }
    
    public void validateApartmentInfo(ApartmentInfoDto apartmentInfoDto){
        if(apartmentInfoDto.getNumberOfFloors() != null && apartmentInfoDto.getMaxFloorBuilding() != null &&
        apartmentInfoDto.getNumberOfFloors() > apartmentInfoDto.getMaxFloorBuilding()){
            throw new ValidationException("Number of floors must be less than or equal to the max floor building");
        }
    }

    public void validateLocationInfo(LocationInfoDto locationInfoDto){}

    public void validatePreferences(PreferencesDto preferencesDto){
        if(preferencesDto.getMinAge() != null && preferencesDto.getMaxAge() != null &&
        preferencesDto.getMinAge() > preferencesDto.getMaxAge()){
            throw new ValidationException("Min age must be less than or equal to the max age");
        }

    }

    public void validatePricingInfo(PricingInfoDto pricingInfoDto){
        if(pricingInfoDto.getMinAmountOfCommunalService() != null && pricingInfoDto.getMaxAmountOfCommunalService() != null &&
        pricingInfoDto.getMinAmountOfCommunalService() > pricingInfoDto.getMaxAmountOfCommunalService()){
            throw new ValidationException("Min amount of communal service must be less than or equal to the max amount of communal service");
        }
    }

    public void validateBusinessRules(AnnouncementCreateRequest announcementCreateRequest){
        if(announcementCreateRequest.getPhoto() != null && !isValidPhotoUrl(announcementCreateRequest.getPhoto())){
            throw new ValidationException("Photo must be a valid URL");
        }
    }

    public boolean isValidPhotoUrl(String photoUrl){
        return photoUrl.startsWith("http") && photoUrl.endsWith(".jpg") || photoUrl.endsWith(".png");
    }

}

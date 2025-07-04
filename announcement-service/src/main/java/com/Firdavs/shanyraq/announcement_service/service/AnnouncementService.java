package com.Firdavs.shanyraq.announcement_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.Firdavs.shanyraq.announcement_service.dto.AnnouncementCreateRequest;
import com.Firdavs.shanyraq.announcement_service.dto.AnnouncementDto;
import com.Firdavs.shanyraq.announcement_service.model.Announcement;
import com.Firdavs.shanyraq.announcement_service.repository.AnnouncementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;
    private final AnnouncementValidationService announcementValidationService;

    public AnnouncementDto createAnnouncement(AnnouncementCreateRequest announcementCreateRequest){
        announcementValidationService.validateAnnouncement(announcementCreateRequest);

        // Announcement announcement = buildAnnouncementFromRequest(announcementCreateRequest.getUserId(), announcementCreateRequest);
        // return announcementRepository.save(announcement);
    }

    // private Announcement buildAnnouncementFromRequest(AnnouncementCreateRequest request) {
    //     return Announcement.builder()
    //         .role(request.getRole())
    //         .title(request.getTitle())
    //         .selectedGender(request.getSelectedGender())
    //         .arrivalDate(request.getArrivalDate())
    //         .ownersName(request.getOwnersName())
    //         .ownersPhoneNumber(request.getOwnersPhoneNumber())
    //         .photo(request.getPhoto())
    //         .isDraft(true) // Start as draft
    //         .isArchived(false)
    //         .isDeleted(false)
    //         .createdAt(LocalDateTime.now())
    //         .updatedAt(LocalDateTime.now())
    //         // Map nested DTOs to entities
    //         .locationInfo(mapLocationInfo(request.getLocationInfo()))
    //         .apartmentInfo(mapApartmentInfo(request.getApartmentInfo()))
    //         .preferences(mapPreferences(request.getPreferences()))
    //         .pricingInfo(mapPricingInfo(request.getPricingInfo()))
    //         .build();
    // }

}

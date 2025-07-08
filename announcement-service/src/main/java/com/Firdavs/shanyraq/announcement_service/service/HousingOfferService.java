package com.Firdavs.shanyraq.announcement_service.service;

import com.Firdavs.shanyraq.announcement_service.dto.HousingOfferDto;
import com.Firdavs.shanyraq.announcement_service.dto.HousingOfferResponse;
import com.Firdavs.shanyraq.announcement_service.dto.Response;
import com.Firdavs.shanyraq.announcement_service.dto.UpdateHousingOfferDto;
import com.Firdavs.shanyraq.announcement_service.model.HousingOffer;
import com.Firdavs.shanyraq.announcement_service.repository.HousingOfferRepository;
import com.Firdavs.shanyraq.announcement_service.service.utility.HouseOfferMapStruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HousingOfferService {

    private final HousingOfferRepository housingOfferRepository;
    private final HouseOfferMapStruct mapper;

    public HousingOfferResponse createOffer(HousingOfferDto housingOfferDto, Long userId) {
        HousingOffer entity = mapper.toEntity(housingOfferDto, userId);
        housingOfferRepository.save(entity);
        return mapper.toResponse(entity);
    }

    public Page<HousingOfferResponse> getOffers(int page, int size, Long region, Integer minRooms, Integer maxRent) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<HousingOffer> offers = housingOfferRepository.searchOffers(region, minRooms, maxRent, pageable);
        return offers.map(mapper::toResponse);
    }

    public HousingOfferResponse updateOffer(Long id, UpdateHousingOfferDto dto, Long userId) {
        HousingOffer offer = housingOfferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Housing offer not found"));

        if(!offer.getUserId().equals(userId)){
            throw new RuntimeException("You can not update offer of another person");
        }

        mapper.updateFromDto(dto, offer); // PATCH logic
        housingOfferRepository.save(offer);
        return mapper.toResponse(offer);
    }

    public HousingOfferResponse getOffer(Long id){
        HousingOffer offer = housingOfferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Housing offer not found"));

        return mapper.toResponse(offer);
    }

    public Response deleteOffer(Long id, Long userId){
        HousingOffer offer  = housingOfferRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Housing offer not found"));

        if(!offer.getUserId().equals(userId)){
            throw new RuntimeException("You can not delete offer of another person");
        }

        housingOfferRepository.delete(offer);

        return Response.builder()
                .code("200")
                .message("Housing offer was successfully deleted")
                .build();
    }
}

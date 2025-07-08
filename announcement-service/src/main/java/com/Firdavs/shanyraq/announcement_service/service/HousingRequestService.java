package com.Firdavs.shanyraq.announcement_service.service;

import com.Firdavs.shanyraq.announcement_service.dto.HousingRequestDto;
import com.Firdavs.shanyraq.announcement_service.dto.HousingRequestResponse;
import com.Firdavs.shanyraq.announcement_service.dto.Response;
import com.Firdavs.shanyraq.announcement_service.dto.UpdateHousingRequestDto;
import com.Firdavs.shanyraq.announcement_service.model.HousingRequest;
import com.Firdavs.shanyraq.announcement_service.repository.HousingRequestRepository;
import com.Firdavs.shanyraq.announcement_service.service.utility.HouseOfferMapStruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HousingRequestService {

    private final HousingRequestRepository housingRequestRepository;
    private final HouseOfferMapStruct mapper;

    public HousingRequestResponse createRequest(HousingRequestDto dto, Long userId){
        HousingRequest request = mapper.toEntity(dto, userId);
        housingRequestRepository.save(request);
        return mapper.toResponse(request);
    }

    public Page<HousingRequestResponse> getRequests(
            int page, int size, String occupation, Integer monthtlyIncome, Boolean hasPests,
            Boolean isSmoker, Boolean isStudent, Integer maxRent, Integer maxDeposit){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        Page<HousingRequest> requests = housingRequestRepository.searchRequests(occupation,
                monthtlyIncome, hasPests, isStudent, isSmoker, maxRent, maxDeposit, pageable);

        return requests.map(mapper::toResponse);
    }

    public HousingRequestResponse getRequest(Long id){
        HousingRequest request = housingRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Housing request is not found"));

        return mapper.toResponse(request);
    }

    public HousingRequestResponse updateRequest(Long id, UpdateHousingRequestDto dto, Long userId){
        HousingRequest request = housingRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Housing request is not found"));

        if(!request.getUserId().equals(userId)){
            throw  new RuntimeException("You can not update request of another person");
        }

        mapper.updateFromDto(dto, request);
        housingRequestRepository.save(request);
        return mapper.toResponse(request);
    }

    public Response deleteRequest(Long id, Long userId){
        HousingRequest request = housingRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Housing request is not found"));

        if(!request.getUserId().equals(userId)){
            throw  new RuntimeException("You can not delete request of another person");
        }
        housingRequestRepository.delete(request);
        return Response.builder()
                .code("200: Ok")
                .message("Housing request was deleted")
                .build();
    }
}

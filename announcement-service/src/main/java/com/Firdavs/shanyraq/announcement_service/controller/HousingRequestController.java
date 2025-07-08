package com.Firdavs.shanyraq.announcement_service.controller;

import com.Firdavs.shanyraq.announcement_service.dto.*;
import com.Firdavs.shanyraq.announcement_service.service.HousingRequestService;
import com.Firdavs.shanyraq.announcement_service.service.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class HousingRequestController {

    private final HousingRequestService housingRequestService;
    private final UserServiceClient userServiceClient;

//  POST /requests – create housing request
    @PostMapping
    public ResponseEntity<HousingRequestResponse> createRequest(
            @RequestHeader("Authorization") String token,
            @RequestBody HousingRequestDto dto){

        UserDto user = userServiceClient.getCurrentUser(token);
        return ResponseEntity.ok(housingRequestService.createRequest(dto, user.getId()));
    }

//    GET /requests – get all requests
    @GetMapping
    public ResponseEntity<Page<HousingRequestResponse>> getRequests(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String occupation,
            @RequestParam(required = false) Integer monthlyIncome,
            @RequestParam(required = false) Boolean hasPests,
            @RequestParam(required = false) Boolean isStudent,
            @RequestParam(required = false) Boolean isSmoker,
            @RequestParam(required = false) Integer maxRent,
            @RequestParam(required = false) Integer maxDeposit
    ) {
        return ResponseEntity.ok(housingRequestService.getRequests(
                page, size, occupation, monthlyIncome,
                hasPests, isSmoker, isStudent, maxRent, maxDeposit
        ));
    }

//    GET /requests/{id} – view request
    @GetMapping("/{id}")
    public ResponseEntity<HousingRequestResponse> getRequest(@PathVariable Long id){
        return ResponseEntity.ok(housingRequestService.getRequest(id));
    }

//    Patch /requests/{id} – update
    @PatchMapping("{id}")
    public ResponseEntity<HousingRequestResponse> updateRequest(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id, @RequestBody UpdateHousingRequestDto dto){

        UserDto user = userServiceClient.getCurrentUser(token);
        return ResponseEntity.ok(housingRequestService.updateRequest(id, dto, user.getId()));
    }

//    DELETE /requests/{id} – delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteRequest(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id){

        UserDto user = userServiceClient.getCurrentUser(token);
        return ResponseEntity.ok(housingRequestService.deleteRequest(id, user.getId()));
    }
}

package com.Firdavs.shanyraq.announcement_service.controller;

import com.Firdavs.shanyraq.announcement_service.dto.*;
import com.Firdavs.shanyraq.announcement_service.service.HousingOfferService;
import com.Firdavs.shanyraq.announcement_service.service.UserServiceClient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class HousingOfferController {

    private final HousingOfferService housingOfferService;
    private final UserServiceClient userServiceClient;
    //post offers
    @PostMapping
    public ResponseEntity<HousingOfferResponse> createOffer(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody HousingOfferDto housingOfferDto){
        UserDto user = userServiceClient.getCurrentUser(token);
        return ResponseEntity.ok(housingOfferService.createOffer(housingOfferDto, user.getId()));
    }

    //get offers
    @GetMapping
    public ResponseEntity<Page<HousingOfferResponse>> getOffers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long region,
            @RequestParam(required = false) Integer minRooms,
            @RequestParam(required = false) Integer maxRent
    ){
        return ResponseEntity.ok(housingOfferService.getOffers(page, size, region, minRooms, maxRent));
    }

    //get /offers/{id}
    @GetMapping("/{id}")
    public ResponseEntity<HousingOfferResponse> getOffer(@PathVariable Long id){
        return ResponseEntity.ok(housingOfferService.getOffer(id));
    }

    //put /offers/{id}
    @PatchMapping("/{id}")
    public ResponseEntity<HousingOfferResponse> updateOffer(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id,
            @Valid @RequestBody UpdateHousingOfferDto dto){
        UserDto user = userServiceClient.getCurrentUser(token);
        return ResponseEntity.ok(housingOfferService.updateOffer(id, dto, user.getId()));
    }

    //delete /offers/ {id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteOffer(
            @RequestHeader("Authorization") String token,
            @PathVariable Long id){

        UserDto user = userServiceClient.getCurrentUser(token);
        return ResponseEntity.ok(housingOfferService.deleteOffer(id, user.getId()));
    }
}

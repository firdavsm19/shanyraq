package com.Firdavs.Shanyraq.user_service.controller;

import com.Firdavs.Shanyraq.user_service.dto.PhotoRequest;
import com.Firdavs.Shanyraq.user_service.dto.UserProfileDto;
import com.Firdavs.Shanyraq.user_service.dto.UserProfileRequest;
import com.Firdavs.Shanyraq.user_service.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserProfileService userProfileService;

    // GET /api/profiles/{userId}
    @GetMapping("/{userId}")
    public ResponseEntity<UserProfileDto> getProfile(@PathVariable Long userId){
        return ResponseEntity.ok(userProfileService.getProfile(userId));
    }

    // PUT /api/profiles/me
    @PutMapping("/me")
    public ResponseEntity<UserProfileDto> putProfile(
            Authentication authentication,
            @RequestBody UserProfileRequest request) {

        Long userId = Long.valueOf(authentication.getName());
        return ResponseEntity.ok(userProfileService.putProfile(userId, request));
    }

    // POST /api/profiles/{userId}/photo
    @PostMapping("/{userId}/photo")
    public ResponseEntity<Map<String, String>> postPhoto(Authentication authentication,
                                                         @RequestBody PhotoRequest request){
        Long userId = Long.valueOf(authentication.getName());
        return ResponseEntity.ok(userProfileService.postPhoto(userId, request));
    }
}

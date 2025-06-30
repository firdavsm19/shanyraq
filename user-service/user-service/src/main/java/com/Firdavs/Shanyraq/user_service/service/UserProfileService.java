package com.Firdavs.Shanyraq.user_service.service;

import com.Firdavs.Shanyraq.user_service.dto.PhotoRequest;
import com.Firdavs.Shanyraq.user_service.dto.UserDto;
import com.Firdavs.Shanyraq.user_service.dto.UserProfileDto;
import com.Firdavs.Shanyraq.user_service.dto.UserProfileRequest;
import com.Firdavs.Shanyraq.user_service.model.Session;
import com.Firdavs.Shanyraq.user_service.model.User;
import com.Firdavs.Shanyraq.user_service.model.UserAuth;
import com.Firdavs.Shanyraq.user_service.repository.SessionRepository;
import com.Firdavs.Shanyraq.user_service.repository.UserProfileRepository;
import com.Firdavs.Shanyraq.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final UserProfileRepository userProfileRepository;

    public UserProfileDto getProfile(Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User is not found"));

        return UserProfileDto.builder()
                .user(mapToUserDto(user, user.getUserAuth()))
                .birthDate(user.getUserProfile().getBirthDate())
                .gender(user.getUserProfile().getGender())
                .profilePhoto(user.getUserProfile().getProfilePhoto())
                .coverLetter(user.getUserProfile().getCoverLetter())
                .isSurveyCompleted(user.getUserProfile().isSurveyCompleted())
                .build();
    }

    public UserProfileDto putProfile(Long userId, UserProfileRequest request){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if(!user.getUserAuth().isVerified()){
            throw new RuntimeException("User is not verified");
        }
        user.getUserProfile().setGender(request.getGender());
        user.getUserProfile().setBirthDate(request.getBirthdate());
        user.getUserProfile().setCoverLetter(request.getCoverLetter());

        userProfileRepository.save(user.getUserProfile());

        return UserProfileDto.builder()
                .user(mapToUserDto(user, user.getUserAuth()))
                .birthDate(user.getUserProfile().getBirthDate())
                .gender(user.getUserProfile().getGender())
                .profilePhoto(user.getUserProfile().getProfilePhoto())
                .coverLetter(user.getUserProfile().getCoverLetter())
                .isSurveyCompleted(user.getUserProfile().isSurveyCompleted())
                .build();
    }

    public Map<String, String> postPhoto(Long userId, PhotoRequest request){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if(!user.getUserAuth().isVerified()) throw new RuntimeException("User is not verified");

        user.getUserProfile().setProfilePhoto(request.getProfilePhoto());
        userProfileRepository.save(user.getUserProfile());

        return Map.of("message", "Photo is posted!");

    }

    public UserDto mapToUserDto(User user, UserAuth userAuth){
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .isVerified(userAuth.isVerified())
                .build();
    }
}

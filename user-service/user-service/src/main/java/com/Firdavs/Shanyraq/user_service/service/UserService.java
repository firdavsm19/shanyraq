package com.Firdavs.Shanyraq.user_service.service;

import com.Firdavs.Shanyraq.user_service.dto.UserDto;
import com.Firdavs.Shanyraq.user_service.model.User;
import com.Firdavs.Shanyraq.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public UserDto getUser(Long userId, Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .isVerified(user.getUserAuth().isVerified())
                .build();
    }
}

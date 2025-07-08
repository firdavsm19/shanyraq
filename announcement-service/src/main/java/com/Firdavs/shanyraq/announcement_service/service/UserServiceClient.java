package com.Firdavs.shanyraq.announcement_service.service;

import com.Firdavs.shanyraq.announcement_service.config.WebClientConfig;
import com.Firdavs.shanyraq.announcement_service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UserServiceClient {

    private final WebClient webClient;

    public UserDto getCurrentUser(String token){
        System.out.println("token: " + token);
        return webClient.get()
                .uri("http://localhost:8081/api/auth/me")
                .header("Authorization",token)
                .retrieve()
                .bodyToMono(UserDto.class).block();
    }
}

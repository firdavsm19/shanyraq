package com.Firdavs.Shanyraq.user_service.controller;

import com.Firdavs.Shanyraq.user_service.dto.UserDto;
import com.Firdavs.Shanyraq.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // GET /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(Authentication authentication, @PathVariable Long id){
        Long userId = Long.valueOf(authentication.getName());
        return ResponseEntity.ok(userService.getUser(userId, id));
    }

    // POST /api/users


    // PUT /api/users/{id}


    // DELETE /api/users/{id}


    // GET /api/users (list/search)
}

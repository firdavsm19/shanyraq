package com.Firdavs.Shanyraq.user_service.controller;

import com.Firdavs.Shanyraq.user_service.service.PasswordResetService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/password")
@RequiredArgsConstructor
public class PasswordResetController {
    private final PasswordResetService passwordResetService;

    // POST /api/password/reset
    @PostMapping("/reset")
    public ResponseEntity<Map<String, String>> requestReset(@RequestParam String email, HttpServletRequest request){
        String ip = request.getRemoteAddr();
        return ResponseEntity.ok(passwordResetService.requestReset(ip, email));
    }

    // POST /api/password/confirm
    @PostMapping("/confirm")
    public ResponseEntity<Map<String, String>> confirmToken(@RequestParam String token){
        return ResponseEntity.ok(passwordResetService.confirmToken(token));
    }

    @PutMapping("/change")
    public ResponseEntity<Map<String, String>> changePassword(@RequestParam String token, @RequestParam String newPassword){
        return ResponseEntity.ok(passwordResetService.changePassword(token, newPassword));
    }
    // PUT /api/password/change
}

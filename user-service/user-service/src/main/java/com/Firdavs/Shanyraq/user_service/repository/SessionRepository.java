package com.Firdavs.Shanyraq.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Firdavs.Shanyraq.user_service.model.Session;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findByAccessToken(String accessToken);
    Optional<Session> findByRefreshToken(String refreshToken);
}

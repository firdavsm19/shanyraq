package com.Firdavs.Shanyraq.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Firdavs.Shanyraq.user_service.model.PasswordResetModel;

import java.util.Optional;

public interface PasswordResetModelRepository extends JpaRepository<PasswordResetModel, Long> {
    Optional<PasswordResetModel> findByToken(String token);
}

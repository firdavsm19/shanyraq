package com.Firdavs.Shanyraq.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Firdavs.Shanyraq.user_service.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    
}

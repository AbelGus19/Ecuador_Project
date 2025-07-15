package com.ecuadorceramico.userprofileservice.mapper;

import com.ecuadorceramico.userprofileservice.entity.UserProfile;
import com.ecuadorceramico.userprofileservice.dto.UserProfileDTO;
import com.ecuadorceramico.userprofileservice.dto.CreateUserProfileRequest;
import com.ecuadorceramico.userprofileservice.dto.UpdateUserProfileRequest;

public class UserProfileMapper {

    public static UserProfile toEntity(CreateUserProfileRequest req) {
        UserProfile entity = new UserProfile();
        entity.setUserId(req.getUserId());
        entity.setFullName(req.getFullName());
        entity.setEmail(req.getEmail());
        entity.setBio(req.getBio());
        entity.setAvatarUrl(req.getAvatarUrl());
        return entity;
    }

    public static UserProfileDTO toDTO(UserProfile entity) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setFullName(entity.getFullName());
        dto.setEmail(entity.getEmail());
        dto.setBio(entity.getBio());
        dto.setAvatarUrl(entity.getAvatarUrl());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public static void updateEntity(UserProfile entity, UpdateUserProfileRequest req) {
        entity.setFullName(req.getFullName());
        entity.setEmail(req.getEmail());
        entity.setBio(req.getBio());
        entity.setAvatarUrl(req.getAvatarUrl());
    }
}
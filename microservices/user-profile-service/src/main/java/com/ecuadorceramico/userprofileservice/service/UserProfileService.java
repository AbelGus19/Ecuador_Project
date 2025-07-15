package com.ecuadorceramico.userprofileservice.service;

import com.ecuadorceramico.userprofileservice.dto.UserProfileDTO;
import com.ecuadorceramico.userprofileservice.dto.CreateUserProfileRequest;
import com.ecuadorceramico.userprofileservice.dto.UpdateUserProfileRequest;

public interface UserProfileService {
    UserProfileDTO createProfile(CreateUserProfileRequest request);
    UserProfileDTO getProfile(Long id);
    UserProfileDTO getProfileByUserId(Long userId);
    UserProfileDTO updateProfile(Long id, UpdateUserProfileRequest request);
    void deleteProfile(Long id);
}
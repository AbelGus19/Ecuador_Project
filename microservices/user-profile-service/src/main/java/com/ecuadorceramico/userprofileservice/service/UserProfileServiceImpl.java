package com.ecuadorceramico.userprofileservice.service;

import com.ecuadorceramico.userprofileservice.entity.UserProfile;
import com.ecuadorceramico.userprofileservice.repository.UserProfileRepository;
import com.ecuadorceramico.userprofileservice.dto.UserProfileDTO;
import com.ecuadorceramico.userprofileservice.dto.CreateUserProfileRequest;
import com.ecuadorceramico.userprofileservice.dto.UpdateUserProfileRequest;
import com.ecuadorceramico.userprofileservice.mapper.UserProfileMapper;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository repository;

    public UserProfileServiceImpl(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserProfileDTO createProfile(CreateUserProfileRequest request) {
        if (repository.findByUserId(request.getUserId()).isPresent()) {
            throw new IllegalArgumentException("Profile already exists for userId " + request.getUserId());
        }
        UserProfile saved = repository.save(UserProfileMapper.toEntity(request));
        return UserProfileMapper.toDTO(saved);
    }

    @Override
    public UserProfileDTO getProfile(Long id) {
        return UserProfileMapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Profile not found")));
    }

    @Override
    public UserProfileDTO getProfileByUserId(Long userId) {
        return UserProfileMapper.toDTO(repository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("Profile not found")));
    }

    @Override
    public UserProfileDTO updateProfile(Long id, UpdateUserProfileRequest request) {
        UserProfile entity = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Profile not found"));
        UserProfileMapper.updateEntity(entity, request);
        return UserProfileMapper.toDTO(repository.save(entity));
    }

    @Override
    public void deleteProfile(Long id) {
        repository.deleteById(id);
    }
}
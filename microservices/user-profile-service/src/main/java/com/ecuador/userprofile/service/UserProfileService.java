package com.ecuador.userprofile.service;

import com.ecuador.userprofile.entity.UserProfile;
import com.ecuador.userprofile.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {

    private final UserProfileRepository repository;

    public UserProfile save(UserProfile profile) {
        return repository.save(profile);
    }

    public List<UserProfile> getAll() {
        return repository.findAll();
    }

    public UserProfile getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public UserProfile getByUsername(String username) {
        return repository.findByUsername(username).orElse(null);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public UserProfile update(String id, UserProfile updatedProfile) {
    Optional<UserProfile> existingProfile = repository.findById(id);
    if (existingProfile.isPresent()) {
        UserProfile profile = existingProfile.get();
        profile.setUsername(updatedProfile.getUsername());
        profile.setFullName(updatedProfile.getFullName());
        profile.setEmail(updatedProfile.getEmail());
        profile.setPhoneNumber(updatedProfile.getPhoneNumber());
        profile.setAddress(updatedProfile.getAddress());
        return repository.save(profile);
    } else {
        throw new RuntimeException("UserProfile not found with id: " + id);
    }
    }

}
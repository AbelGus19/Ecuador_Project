package com.ecuadorceramico.userprofileservice.controller;

import com.ecuadorceramico.userprofileservice.dto.UserProfileDTO;
import com.ecuadorceramico.userprofileservice.dto.CreateUserProfileRequest;
import com.ecuadorceramico.userprofileservice.dto.UpdateUserProfileRequest;
import com.ecuadorceramico.userprofileservice.service.UserProfileService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@RequestMapping("/profiles")
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserProfileDTO> createProfile(@Valid @RequestBody CreateUserProfileRequest request) {
        UserProfileDTO created = service.createProfile(request);
        return ResponseEntity.created(URI.create("/profiles/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getProfile(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProfile(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserProfileDTO> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getProfileByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDTO> updateProfile(@PathVariable Long id, @Valid @RequestBody UpdateUserProfileRequest request) {
        return ResponseEntity.ok(service.updateProfile(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        service.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
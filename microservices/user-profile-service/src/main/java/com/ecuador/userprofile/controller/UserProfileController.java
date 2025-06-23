package com.ecuador.userprofile.controller;

import com.ecuador.userprofile.entity.UserProfile;
import com.ecuador.userprofile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-profiles")
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService service;

    @PostMapping
    public ResponseEntity<UserProfile> create(@RequestBody UserProfile profile) {
        return ResponseEntity.ok(service.save(profile));
    }

    @GetMapping
    public ResponseEntity<List<UserProfile>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserProfile> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.getByUsername(username));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfile> update(@PathVariable String id, @RequestBody UserProfile updatedProfile) {
    return ResponseEntity.ok(service.update(id, updatedProfile));
    }

}
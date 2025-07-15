package com.ecuadorceramico.userprofileservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateUserProfileRequest {

    @NotBlank
    @Size(max = 100)
    private String fullName;

    @NotBlank
    @Size(max = 100)
    private String email;

    @Size(max = 500)
    private String bio;

    private String avatarUrl;

    // Getters
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getBio() { return bio; }
    public String getAvatarUrl() { return avatarUrl; }

    // Setters
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setBio(String bio) { this.bio = bio; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
}

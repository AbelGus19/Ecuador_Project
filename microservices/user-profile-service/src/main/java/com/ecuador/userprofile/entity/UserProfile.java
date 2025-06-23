package com.ecuador.userprofile.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {
    @Id
    private String id;
    private String username;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
}
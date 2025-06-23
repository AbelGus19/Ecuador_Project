package com.ecuador.rbac.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rolename;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getRolename() {
        return rolename;
    }
}

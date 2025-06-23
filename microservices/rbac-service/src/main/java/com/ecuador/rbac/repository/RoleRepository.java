package com.ecuador.rbac.repository;

import com.ecuador.rbac.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r.rolename FROM Role r WHERE r.user.username = :username")
    List<String> findRolesByUsername(@Param("username") String username);
}


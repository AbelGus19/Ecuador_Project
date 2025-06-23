package com.ecuador.rbac.controller;

import com.ecuador.rbac.entity.Role;
import com.ecuador.rbac.dto.UserWithRolesDTO;
import com.ecuador.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public Role assignRole(@RequestBody Role role) {
        return roleService.save(role);  
    }

    @GetMapping("/{username}")
    public List<String> getRoles(@PathVariable String username) {
        return roleService.getRolesByUsername(username);
    }

    @GetMapping
    public List<UserWithRolesDTO> getAllUsersWithRoles() {
        return roleService.getAllUsersWithRoles();
    }
}

package com.ecuador.rbac.service;

import com.ecuador.rbac.entity.User;
import com.ecuador.rbac.entity.Role;
import com.ecuador.rbac.dto.UserWithRolesDTO;
import com.ecuador.rbac.repository.UserRepository;
import com.ecuador.rbac.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public List<String> getRolesByUsername(String username) {
        return roleRepository.findRolesByUsername(username);
    }

    public List<UserWithRolesDTO> getAllUsersWithRoles() {
        List<User> users = userRepository.findAll();

        return users.stream().map(user ->
            new UserWithRolesDTO(
                user.getUsername(),
                user.getRoles().stream()
                     .map(Role::getRolename)
                     .collect(Collectors.toList())
            )
        ).collect(Collectors.toList());
    }
}

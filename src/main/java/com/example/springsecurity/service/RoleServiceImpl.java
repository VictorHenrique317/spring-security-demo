package com.example.springsecurity.service;

import com.example.springsecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public String returnRoleNameIfExists(String roleName) {
        boolean exists = roleRepository.existsByRole(roleName).orElseThrow(()->
                        new IllegalArgumentException("No roles with name " + roleName +  " found"));
        return roleName;
    }
}

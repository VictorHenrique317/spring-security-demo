package com.example.springsecurity.repository;

import com.example.springsecurity.domain.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    Optional<Boolean> existsByRole(String role);
}

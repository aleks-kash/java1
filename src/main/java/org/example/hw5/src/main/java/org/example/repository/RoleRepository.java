package org.example.repository;

import org.example.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    Role create(Role role);

    Optional<Role> findById(Long id);

    List<Role> findAll();
}

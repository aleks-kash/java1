package org.example.lesson4.repository;

import org.example.lesson4.model.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(Long id);
}

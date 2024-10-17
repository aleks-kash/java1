package org.example.repository;

import org.example.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User create(User user);

    User update(User user);

    Optional<User> findById(Long id);

    List<User> findAll();
}

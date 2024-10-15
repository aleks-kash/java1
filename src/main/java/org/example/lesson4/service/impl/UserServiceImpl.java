package org.example.lesson4.service.impl;

import org.example.lesson4.dto.UserRegistrationDto;
import org.example.lesson4.dto.UserResponseDto;
import org.example.lesson4.model.User;
import org.example.lesson4.repository.UserRepository;
import org.example.lesson4.service.UserService;
import org.example.lesson4.validation.UserValidator;

import java.util.NoSuchElementException;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto registerUser(UserRegistrationDto userRegistrationDto) {
        try {
            UserValidator.checkEmail(userRegistrationDto.getEmail());

            UserValidator.checkPhoneNumber(userRegistrationDto.getPhoneNumber());

            UserValidator.checkPassword(userRegistrationDto.getPassword(), userRegistrationDto.getRepeatPassword());

            User user = new User(
                null,
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPhoneNumber(),
                userRegistrationDto.getPassword(),
                userRegistrationDto.getRepeatPassword()
            );
            user = userRepository.save(user);

            return new UserResponseDto(user.getId(), user.getEmail(), user.getPhoneNumber());

        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(u -> new UserResponseDto(u.getId(), u.getEmail(), u.getPhoneNumber()))
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }
}

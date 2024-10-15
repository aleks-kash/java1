package org.example.lesson4.service;

import org.example.lesson4.dto.UserRegistrationDto;
import org.example.lesson4.dto.UserResponseDto;

public interface UserService {

    UserResponseDto registerUser(UserRegistrationDto userRegistrationDto);

    UserResponseDto getUserById(Long userId);

}

package org.example.lesson4.service.impl;

import org.example.lesson4.dto.UserRegistrationDto;
import org.example.lesson4.dto.UserResponseDto;
import org.example.lesson4.model.User;
import org.example.lesson4.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.NoSuchElementException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void getUserById_WithValidUserId_ShouldReturnUserResponseDto() {
        Long userId = 1L;
        String userEmail = "user@example.com";
        String userPhoneNumber = "380950000000";
        String userPassword = "password";
        String userRepeatPassword = "password";

        User user = new User(userId, userEmail, userPhoneNumber, userPassword, userRepeatPassword);
        UserResponseDto expectedResponse = new UserResponseDto(userId, userEmail, userPhoneNumber);

        when(userRepository.findById(eq(1L))).thenReturn(Optional.of(user));

        UserResponseDto actualResponse = userService.getUserById(userId);

        assertEquals(expectedResponse, actualResponse);
        assertEquals(expectedResponse.email(), actualResponse.email());
        assertEquals(expectedResponse.phoneNumber(), actualResponse.phoneNumber());

        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void registerUser_WithValidData_ShouldSaveAndReturnUserResponseDto() {
        String userEmail = "newuser@example.com";
        String userPhoneNumber = "380990000000";
        String userPassword = "securePassword";
        String userRepeatPassword = "securePassword";

        UserRegistrationDto registrationDto = new UserRegistrationDto();
        registrationDto.setEmail(userEmail);
        registrationDto.setPhoneNumber(userPhoneNumber);
        registrationDto.setPassword(userPassword);
        registrationDto.setRepeatPassword(userRepeatPassword);

        User savedUser = new User(2L, userEmail, userPhoneNumber, userPassword, null);
        UserResponseDto expectedResponse = new UserResponseDto(2L, userEmail, userPhoneNumber);

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserResponseDto actualResponse = userService.registerUser(registrationDto);

        assertEquals(expectedResponse, actualResponse);
        assertEquals(expectedResponse.email(), actualResponse.email());
        assertEquals(expectedResponse.phoneNumber(), actualResponse.phoneNumber());

        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void getUserById_WithInvalidUserId_ShouldThrowException() {
        Long invalidUserId = 999L;

        when(userRepository.findById(invalidUserId)).thenReturn(Optional.empty());

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () ->
                userService.getUserById(invalidUserId)
        );

        assertEquals("User not found", exception.getMessage());

        verify(userRepository, times(1)).findById(invalidUserId);
    }
}

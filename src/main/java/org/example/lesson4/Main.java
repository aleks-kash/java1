package org.example.lesson4;

import org.example.lesson4.dto.UserRegistrationDto;
import org.example.lesson4.dto.UserResponseDto;
import org.example.lesson4.repository.impl.UserRepositoryImpl;
import org.example.lesson4.service.UserService;
import org.example.lesson4.service.impl.UserServiceImpl;
import org.example.lesson4.util.ConnectionUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ConnectionUtil.migration();

        UserService userService = new UserServiceImpl(new UserRepositoryImpl());

        UserRegistrationDto newUser = new UserRegistrationDto();
        newUser.setEmail("user@example.com");
        newUser.setPhoneNumber("380950000000");
        newUser.setPassword("password");
        newUser.setRepeatPassword("password");

        UserResponseDto response = userService.registerUser(newUser);

        if (response != null) {
            System.out.println("Registration successful!");
            System.out.println("User ID: " + response.id());
            System.out.println("User Email: " + response.email());
            System.out.println("User Phone: " + response.phoneNumber());
        } else {
            System.out.println("Registration failed.");
        }

        System.out.println("-------------------------------");
        System.out.println("userById:" + userService.getUserById(6L));
    }
}
package org.example.lesson4.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserValidatorTest {
    @Test
    void checkEmail_WithValidEmail_ShouldPass() {
        assertDoesNotThrow(() -> UserValidator.checkEmail("user@example.com"));
    }

    @Test
    void checkEmail_WithInvalidEmail_ShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserValidator.checkEmail("invalid-email")
        );
        assertEquals("Invalid email format.", exception.getMessage());
    }

    @Test
    void checkEmail_WithEmptyEmail_ShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserValidator.checkEmail("")
        );
        assertEquals("Email is required.", exception.getMessage());
    }

    @Test
    void checkPhoneNumber_WithValidPhoneNumber_ShouldPass() {
        assertDoesNotThrow(() -> UserValidator.checkPhoneNumber("380950000000"));
    }

    @Test
    void checkPhoneNumber_WithInvalidPhoneNumber_ShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserValidator.checkPhoneNumber("invalid-phone")
        );
        assertEquals("Invalid phone number format. Should be 10 to 15 digits.", exception.getMessage());
    }

    @Test
    void checkPhoneNumber_WithEmptyPhoneNumber_ShouldPass() {
        assertDoesNotThrow(() -> UserValidator.checkPhoneNumber(""));
    }

    @Test
    void testCheckPassword_WithMatchingPasswords_ShouldPass() {
        assertDoesNotThrow(() -> UserValidator.checkPassword("password123", "password123"));
    }

    @Test
    void testCheckPassword_WithNonMatchingPasswords_ShouldThrowException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserValidator.checkPassword("password123", "differentPassword")
        );
        assertEquals("Passwords do not match.", exception.getMessage());
    }

    @Test
    void testCheckPassword_WithEmptyPassword_ShouldThrowException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                UserValidator.checkPassword("", "password123")
        );
        assertEquals("Password is required.", exception.getMessage());
    }
}

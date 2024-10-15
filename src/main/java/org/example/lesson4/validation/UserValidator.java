package org.example.lesson4.validation;

public final class UserValidator {

    private UserValidator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void checkEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required.");
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
    }

    public static void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return;
        }

        String phoneRegex = "^[0-9]{10,15}$";
        if (!phoneNumber.matches(phoneRegex)) {
            throw new IllegalArgumentException("Invalid phone number format. Should be 10 to 15 digits.");
        }
    }

    public static void checkPassword(String password, String repeatPassword) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password is required.");
        }

        if (repeatPassword == null || repeatPassword.isEmpty()) {
            throw new IllegalArgumentException("Repeat password is required.");
        }

        if (!password.equals(repeatPassword)) {
            throw new IllegalArgumentException("Passwords do not match.");
        }
    }
}

package org.example;

import org.example.model.Role;
import org.example.model.User;
import org.example.repository.RoleRepository;
import org.example.repository.impl.RoleRepositoryImpl;
import org.example.repository.UserRepository;
import org.example.repository.impl.UserRepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        RoleRepository roleRepository = new RoleRepositoryImpl();

        System.out.println("\nSaving user1...");
        User user1 = new User();
        user1.setName("John");
        user1.setEmail("user123@gmail.com");
        user1 = userRepository.create(user1);

        User userFromDB = userRepository.findById(1L)
            .orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println(userFromDB);

        System.out.println("\nSaving role1...");
        Role role1 = new Role();
        role1.setName("ADMIN");
        roleRepository.create(role1);

        System.out.println("\nSaving role1 for user1...");
        user1.setRoles(List.of(role1));
        userRepository.update(user1);

        System.out.println("\nSaving user2...");
        User user2 = new User();
        user2.setName("Jane");
        user2.setEmail("user456@gmail.com");
        userRepository.create(user2);

        System.out.println("\nSaving role2...");
        Role role2 = new Role();
        role2.setName("READER");
        roleRepository.create(role2);

        System.out.println("\nSaving role2 for user2...");
        user2.setRoles(List.of(role2));
        userRepository.update(user2);

        System.out.println("\nSaving user3...");
        User user3 = new User();
        user3.setName("John");
        user3.setEmail("678@gmail.com");
        userRepository.create(user3);

        Role roleFromDB = roleRepository.findById(1L)
            .orElseThrow(() -> new RuntimeException("Role not found"));
        System.out.println(roleFromDB);

        System.out.println("\nSaving roleFromDB for user3...");
        user3.setRoles(List.of(roleFromDB));
        userRepository.update(user3);

        System.out.println("\nFinding all users...");
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);

        System.out.println("\nFinding all roles...");
        List<Role> roles = roleRepository.findAll();
        roles.forEach(System.out::println);
    }
}

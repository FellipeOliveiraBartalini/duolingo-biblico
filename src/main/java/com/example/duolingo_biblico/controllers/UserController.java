package com.example.duolingo_biblico.controllers;

import com.example.duolingo_biblico.models.UserModel;
import com.example.duolingo_biblico.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserModel getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable Long id, @RequestBody UserModel userModel) {
        UserModel existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(userModel.getUsername());
        existingUser.setEmail(userModel.getEmail());
        existingUser.setRole(userModel.getRole());
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}

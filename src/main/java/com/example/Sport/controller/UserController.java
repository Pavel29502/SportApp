package com.example.Sport.controller;

import com.example.Sport.bean.User;
import com.example.Sport.dto.UserRequestDTO;
import com.example.Sport.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class UserController {

    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
        public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody UserRequestDTO user) {
        return userService.save(user);
    }


    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserRequestDTO user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}





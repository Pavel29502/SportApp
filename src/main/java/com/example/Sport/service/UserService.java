package com.example.Sport.service;


import com.example.Sport.bean.User;
import com.example.Sport.dto.UserRequestDTO;
import com.example.Sport.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User save(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        return userRepository.save(user);
    }

    public User update(Long id, UserRequestDTO userRequestDTO) {
        User existUser = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(
                "User not found with id: " + id));
        if (userRequestDTO.getName() != null) {
            existUser.setName(userRequestDTO.getName());
        }
        return userRepository.save(existUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

package com.example.User_Management.service;

import com.example.User_Management.data.User;
import com.example.User_Management.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired

    private UserRepository userRepository;

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null); // Return null if user is not found
    }


    public User createUser(User user){
        return userRepository.save(user);
    }


    public  User updateUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Email with ID " + id + " deleted successfully.";
        } else {
            return "User with ID " + id + " does not exist.";
        }
    }

    public List<User> getUsersByName(String name){
        return userRepository.findByName(name);
    }

    public List<User> getUsersByNameAndRole(String name, User.UserRole role){
        return userRepository.findByNameAndRole(name,role);
    }
}

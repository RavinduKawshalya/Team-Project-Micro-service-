package com.example.User_Management.controller;

import com.example.User_Management.data.User;
import com.example.User_Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired

    private UserService userService;

    @GetMapping(path="/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID " + id + " does not exist.");
        }

        return ResponseEntity.ok(user);
    }


    @PostMapping(path = "/users")
    public User createUser(@RequestBody User user)
    {return userService.createUser(user);}

    @PutMapping(path = "/users")
    public User updateUser(@RequestBody User user)
    {return userService.updateUser(user);}

    @DeleteMapping(path = "/users/{id}")
    public String deleteUser(@PathVariable int id)
    {return userService.deleteUser(id);}

    @GetMapping(path="/users/search_by_name")
    public List<User> getUsersByName(@RequestParam("name")  String name){
        return userService.getUsersByName(name);
    }

    @GetMapping(path="/users/search_by_name_and_role")
    public ResponseEntity<?> getUsersByNameAndRole(
            @RequestParam("name") String name,
            @RequestParam("role") String roleStr) {

        User.UserRole role;
        try {
            role = User.UserRole.valueOf(roleStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("❌ Error: '" + roleStr + "' is not a valid role. " +
                    "Please use one of the following: STUDENT, STAFF, SPONSOR, ORGANIZER.");
        }

        List<User> users = userService.getUsersByNameAndRole(name, role);

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("⚠️ No users found with name '" + name + "' and role '" + role + "'.");
        }

        return ResponseEntity.ok(users);
    }

}

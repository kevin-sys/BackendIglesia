/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Backend.controller;

import com.example.Backend.dao.UserService;
import com.example.Backend.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public User submitUser(@RequestBody User newUser) {
        User user = userService.addUser(newUser);
        return user;
    }

    @GetMapping("all-users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}

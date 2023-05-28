/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Backend.dao;

import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.Backend.model.User;
import java.util.UUID;

@Service
public class UserService {

    private List<User> userDataSource;

    public UserService() {
        userDataSource = new LinkedList<>();
    }

    public User addUser(User user) {
        user.setId(UUID.randomUUID());
        this.userDataSource.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userDataSource;
    }

}

package com.example.demo.service;


import com.example.demo.model.User;

import java.util.List;


public interface UserService {
    public List<User> getUsers();

    public User getUserById(int id);

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

}
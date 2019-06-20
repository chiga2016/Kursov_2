package com.kursov.service;

import com.kursov.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findUserByUsername(String username);

    List<User> findAll();

    User findUserById(Long id);



}

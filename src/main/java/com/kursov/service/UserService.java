package com.kursov.service;

import com.kursov.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findUserByUsername(String username);


}

package com.kursov.dao;

import com.kursov.model.Role;
import com.kursov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findUserById(Long id);



}

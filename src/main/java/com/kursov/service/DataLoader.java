package com.kursov.service;

import com.kursov.dao.RoleDao;
import com.kursov.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private RoleDao roleDao;

    @Autowired
    public DataLoader(RoleDao roleDao) {
        this.roleDao = roleDao;
        LoadUsers();
    }

    private void LoadUsers() {
        roleDao.saveAndFlush(new Role("ROLE_USER"));
        roleDao.saveAndFlush(new Role("ROLE_ADMIN"));

    }
}
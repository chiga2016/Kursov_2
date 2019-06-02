package com.kursov.service;

import com.kursov.dao.CarsDao;
import com.kursov.dao.HiberDAO;
import com.kursov.dao.RoleDao;
import com.kursov.dao.UserDao;
import com.kursov.model.Cars;
import com.kursov.model.Role;
import com.kursov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
    private RoleDao roleDao;
    private UserDao userDao;
    private CarsDao carsDao;
    HiberDAO dao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DataLoader(RoleDao roleDao, UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder, CarsDao carsDao) {
        this.roleDao = roleDao;
        this.userDao = userDao;
        this.carsDao = carsDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        LoadUsers();
    }

    private void LoadUsers() {
        roleDao.saveAndFlush(new Role("ROLE_USER"));
        roleDao.saveAndFlush(new Role("ROLE_ADMIN"));

        User user = new User();
        user.setUsername("admin");
        user.setPassword(bCryptPasswordEncoder.encode("admin"));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        roles.add(roleDao.getOne(2L));
        user.setRoles(roles);
        userDao.saveAndFlush(user);

        carsDao.saveAndFlush(new Cars("car1", "Skoda", "M", "2013"));
        carsDao.saveAndFlush(new Cars("car2", "Skoda", "A", "2019"));

//userDao.save(user);
        //dao.addUser(user);
      //  logger.info(user.getUsername());
       // logger.info(user.getPassword());

    }
}
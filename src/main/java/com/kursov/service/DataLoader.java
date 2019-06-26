package com.kursov.service;

import com.kursov.dao.*;
import com.kursov.model.Cars;
import com.kursov.model.Jurnal;
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
    private JurnalDao jurnalDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DataLoader(RoleDao roleDao, UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder, CarsDao carsDao, JurnalDao jurnalDao) {
        this.roleDao = roleDao;
        this.userDao = userDao;
        this.carsDao = carsDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jurnalDao=jurnalDao;
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
        user.setEnabled(true);
        userDao.saveAndFlush(user);

        carsDao.saveAndFlush(new Cars("car1", "Skoda","Fabia", "MT", "2013", true, 7.1f,"././resources/img/fabia.jpg"));
        carsDao.saveAndFlush(new Cars("car2", "Skoda","Rapid", "AT", "2019", true, 12.1f,"././resources/img/rapid.jpg"));
        carsDao.saveAndFlush(new Cars("car3","Octavia", "Skoda", "MT", "2019", true, 3.1f,"././resources/img/octavia.jpg"));
        carsDao.saveAndFlush(new Cars("car4", "Lada", "Granta", "MT", "2013", true, 7.1f,"././resources/img/granta.jpg"));
        carsDao.saveAndFlush(new Cars("car5", "Lada","Kalina", "AT", "2019", true, 12.1f,"././resources/img/kalina.jpg"));
        carsDao.saveAndFlush(new Cars("car6", "Lada","Vesta", "MT", "2019", true, 3.1f,"././resources/img/vesta.jpg"));

       // Jurnal jurnal = new Jurnal();
       // jurnalDao.save(jurnal);
//userDao.save(user);
        //dao.addUser(user);
      //  logger.info(user.getUsername());
       // logger.info(user.getPassword());

    }
}
package com.kursov.service;

import com.kursov.dao.HiberDAO;
import com.kursov.dao.RoleDao;
import com.kursov.dao.UserDao;
import com.kursov.model.Role;
import com.kursov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    HiberDAO dao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        try {
            /* this is whatever code you have already...this is just an example */
            //entityManager.persist(item);
            //entityManager.flush();
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            Date date = new Date((new java.util.Date()).getTime());
            String DateStr = dateFormat.format(date);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.getOne(1L));
            //roles.add(roleDao.getOne(2L));
            user.setRoles(roles);
            user.setDateCreate(date);
            dao.addUser(user);
           // userDao.save(user);
        }
        catch(Exception ex)
        {
            /* below works in conjunction with concrete logging framework */
            logger.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findUserByUsername(String username) {
        return dao.findUserByUsername(username);
    }

    @Override
    public List<User> findAll() {
       return userDao.findAll();
    }
}

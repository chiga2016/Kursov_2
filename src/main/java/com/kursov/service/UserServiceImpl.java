package com.kursov.service;

import com.kursov.dao.HiberDAO;
import com.kursov.dao.RoleDao;
import com.kursov.dao.UserDao;
import com.kursov.model.Role;
import com.kursov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            Set<Role> roles = new HashSet<>();
            roles.add(roleDao.getOne(1L));
            user.setRoles(roles);
            userDao.save(user);
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
}

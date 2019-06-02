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
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsServiceImpl implements CarsService {

    @Autowired
    CarsDao carsDao;

    @Override
    public void save(Cars cars) {
        carsDao.save(cars);
    }

    @Override
    public List<Cars> findAll() {
       return carsDao.findAll();
    }

}

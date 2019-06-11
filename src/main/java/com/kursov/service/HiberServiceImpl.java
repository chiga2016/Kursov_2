package com.kursov.service;

import com.kursov.dao.HiberDAO;
import com.kursov.model.Cars;
import com.kursov.model.Jurnal;
import com.kursov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiberServiceImpl implements HiberService {
    @Autowired
    UserService userService;
    @Autowired
    CarsService carsService;
    @Autowired
    HiberDAO hiberDAO;


    @Override
    public User addCarToUser(long idUser, long idCar) {
        User user = userService.findUserById(idUser);
        Cars cars = carsService.findCarsById(idCar);

        Cars bestBeforeCar = user.getCurrentCar();
        user.setCurrentCar(cars);
        cars.setAvailable(false);
        Jurnal jurnal = new Jurnal(cars, user);

        hiberDAO.addCarToUser(jurnal);

        if (bestBeforeCar!=null){ bestBeforeCar.setAvailable(true);}

        return user;
    }

//    @Override
//    public User delCarToUser(long idUser, long idCar) {
//return new User();
//    }
}

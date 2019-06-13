package com.kursov.service;

import com.kursov.dao.HiberDAO;
import com.kursov.model.Cars;
import com.kursov.model.Jurnal;
import com.kursov.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HiberServiceImpl implements HiberService {
    @Autowired
    UserService userService;
    @Autowired
    CarsService carsService;
    @Autowired
    HiberDAO hiberDAO;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public User addCarToUser(long idUser, long idCar) {
        User user = userService.findUserById(idUser);
        Cars cars = carsService.findCarsById(idCar);

        Cars bestBeforeCar = user.getCurrentCar();
        user.setCurrentCar(cars);
        cars.setAvailable(false);
        if (bestBeforeCar!=null){
            bestBeforeCar.setAvailable(true);
            Jurnal jurnal = hiberDAO.delCarToUser(user, bestBeforeCar);
            long diff =  jurnal.getEliminDate().getTime() - jurnal.getRegDate().getTime();
            diff = Math.round(diff/1000);
            jurnal.setDuration(diff);
            float cost = diff*bestBeforeCar.getPrice();
            jurnal.setCost(cost);
            log.info("DIFF=" + Long.toString(diff));
            log.info("COST=" + Float.toString(cost));
            hiberDAO.costJurnal(jurnal);

        }
        Jurnal jurnalNew = new Jurnal(cars, user);
        hiberDAO.addCarToUser(jurnalNew, user);
        return user;
    }

    @Override
    public void delCarToUser(long idUser) {
        User user = userService.findUserById(idUser);
        //Cars cars = carsDao.findCarsById(idCar);
        Cars bestBeforeCar = user.getCurrentCar();
        user.setCurrentCar(null);
        bestBeforeCar.setAvailable(true);
       Jurnal jurnal = hiberDAO.delCarToUser(user, bestBeforeCar);
       long diff =  jurnal.getEliminDate().getTime() - jurnal.getRegDate().getTime();
       diff = Math.round(diff/1000);
       jurnal.setDuration(diff);
       float cost = diff*bestBeforeCar.getPrice();
       jurnal.setCost(cost);
       log.info("DIFF=" + Long.toString(diff));
       log.info("COST=" + Float.toString(cost));
       hiberDAO.costJurnal(jurnal);
    }

    @Override
    public List<Jurnal> findJurnalByUserId(long idUser) {
        return hiberDAO.findJurnalByUserId(idUser);
    }

//    @Override
//    public User delCarToUser(long idUser, long idCar) {
//return new User();
//    }
}

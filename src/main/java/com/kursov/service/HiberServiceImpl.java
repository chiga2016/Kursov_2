package com.kursov.service;

import com.kursov.dao.HiberDAO;
import com.kursov.exception.CarNotFoundException;
import com.kursov.exception.IsNotAvailiableException;
import com.kursov.exception.UserNotFoundException;
import com.kursov.model.Cars;
import com.kursov.model.Jurnal;
import com.kursov.model.User;
import com.kursov.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

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
    @Autowired
    private UserValidator userValidator;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    @Transactional
    public User addCarToUser(long idUser, long idCar) throws IsNotAvailiableException, UserNotFoundException, CarNotFoundException {
        User user = userService.findUserById(idUser);
            Cars cars = carsService.findCarsById(idCar);
            /// TODO: wrong id
            Cars bestBeforeCar = user.getCurrentCar();
            if (cars.isAvailable()) {
                user.setCurrentCar(cars);
                cars.setAvailable(false);
                if (bestBeforeCar != null) {
                    bestBeforeCar.setAvailable(true);
                    Jurnal jurnal = calcCostbyUser(user, bestBeforeCar);
                    hiberDAO.costJurnal(jurnal);
                }
                Jurnal jurnalNew = new Jurnal(cars, user);
                hiberDAO.addCarToUser(jurnalNew, user);
            }//  TODO: else

            else {
                throw new IsNotAvailiableException("Car is not availiable!!!");
            }
        return user;
    }

    @Override
    @Transactional
    public void delCarToUser(long idUser) throws UserNotFoundException {
        User user = userService.findUserById(idUser);
        //Cars cars = carsDao.findCarsById(idCar);
        Cars bestBeforeCar = user.getCurrentCar();
        user.setCurrentCar(null);
        bestBeforeCar.setAvailable(true);
        Jurnal jurnal = calcCostbyUser(user, bestBeforeCar);
       hiberDAO.costJurnal(jurnal);
    }

    Jurnal calcCostbyUser(User user, Cars bestBeforeCar){
        Jurnal jurnal = hiberDAO.delCarToUser(user, bestBeforeCar);
        long diff =  jurnal.getEliminDate().getTime() - jurnal.getRegDate().getTime();
        diff = Math.round(diff/(1000*60))+1;
        //if(diff<1){diff=diff+1;}
        jurnal.setDuration(diff);
        float cost = diff*bestBeforeCar.getPrice();
        jurnal.setCost(cost);
        log.info("DIFF=" + Long.toString(diff));
        log.info("COST=" + Float.toString(cost));
        return jurnal;
    }

    @Override
    @Transactional
    public void updateCar(Cars cars) throws CarNotFoundException {
        Cars carOld = carsService.findCarsById(cars.getId());
        log.info("id = "+cars.getId()
                +        "; name = "+cars.getName()
                + "; model = "+cars.getModel()
                + "; transmission = "+        cars.getTransmission()
                + "; year = "+        cars.getYear()
                + "; price = "+       cars.getPrice()
                + "; availiable = "+        cars.isAvailable()
        );
        carOld.setName(cars.getName());
        carOld.setModel(cars.getModel());
        carOld.setTransmission(cars.getTransmission());
        carOld.setYear(cars.getYear());
        carOld.setPrice(cars.getPrice());
        carOld.setAvailable(cars.isAvailable());
/// TODO: проверить транзакции
       // hiberDAO.updateCar(carOld);
    }

    @Override
    public void updateUser(User user , BindingResult bindingResult) throws UserNotFoundException {
        User userOld = userService.findUserById(user.getId());
        log.info("id = "+user.getId()
        +        "; username = "+user.getUsername()
        + "; fam = "+user.getFam()
                        + "; name = "+        user.getName()
                        + "; ot = "+        user.getOt()
                        + "; dr = "+        user.getDr()
                        + "; phone = "+        user.getPhone()
                        + "; vuNumber = "+        user.getVuNumber()
                       // + "; pass = "+        user.getPassword()
                        + "; enable = "+        user.isEnabled()
        );
        userOld.setUsername(user.getUsername());
        userOld.setFam(user.getFam());
        userOld.setName(user.getName());
        userOld.setOt(user.getOt());
        userOld.setDr(user.getDr());
        userOld.setPhone(user.getPhone());
        userOld.setVuNumber(user.getVuNumber());
        //userOld.setPassword(user.getPassword());
        userOld.setEnabled(user.isEnabled());
        hiberDAO.updateUser(userOld);
    }

    @Override
    public List<Jurnal> findJurnalByUserId(long id) {
        log.info("МЫ В ХИБЕРСЕРВИСЕ" + Long.toString(id));
        return hiberDAO.findJurnalByUserId(id);
    }

    public float calcCost(long duration, long car) throws CarNotFoundException {
        Cars currentCar = carsService.findCarsById(car);
        log.info(currentCar.toString());
        float rez=0;
        if (duration>0){
            rez = currentCar.getPrice()*duration/(1000*60);
        }

        return rez;
    }

}

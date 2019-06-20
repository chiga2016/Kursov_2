package com.kursov.service;

import com.kursov.dao.HiberDAO;
import com.kursov.model.Cars;
import com.kursov.model.Jurnal;
import com.kursov.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface HiberService {

   User addCarToUser(long idUser, long idCar);
   //User delCarToUser(long idUser, long idCar);

   void delCarToUser(long idUser);

   List<Jurnal> findJurnalByUserId(long idUser);

   float calcCost(long duration, long car);

   String pullStatus();
    void updateCar(Cars cars);


}

package com.kursov.service;

import com.kursov.dao.HiberDAO;
import com.kursov.exception.CarNotFoundException;
import com.kursov.exception.IsNotAvailiableException;
import com.kursov.exception.UserNotFoundException;
import com.kursov.model.Cars;
import com.kursov.model.Jurnal;
import com.kursov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface HiberService {

   User addCarToUser(long idUser, long idCar) throws IsNotAvailiableException, UserNotFoundException, CarNotFoundException;
   //User delCarToUser(long idUser, long idCar);

   void delCarToUser(long idUser) throws UserNotFoundException;

   List<Jurnal> findJurnalByUserId(long idUser);

   float calcCost(long duration, long car) throws CarNotFoundException;

   void updateCar(Cars cars) throws CarNotFoundException;

   void updateUser(User user , BindingResult bindingResult) throws UserNotFoundException;

}

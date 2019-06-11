package com.kursov.service;

import com.kursov.dao.HiberDAO;
import com.kursov.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public interface HiberService {

   User addCarToUser(long idUser, long idCar);
   //User delCarToUser(long idUser, long idCar);




}

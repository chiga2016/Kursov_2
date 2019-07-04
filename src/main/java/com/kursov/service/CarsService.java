package com.kursov.service;

import com.kursov.exception.CarNotFoundException;
import com.kursov.model.Cars;
import com.kursov.model.User;

import java.util.List;

public interface CarsService {

    void save(Cars cars);

    List<Cars> findAll();

    void saveAndFlush(Cars cars);

    List<Cars> findByAvailible();

    Cars findCarsById(long id) throws CarNotFoundException;

}

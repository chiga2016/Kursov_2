package com.kursov.dao;

import com.kursov.model.Cars;
import com.kursov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsDao  extends JpaRepository<Cars, Long> {

}

package com.kursov.dao;

import com.kursov.model.Cars;
import com.kursov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarsDao  extends JpaRepository<Cars, Long> {

    Cars findCarsById(Long id);

    @Query("select c from Cars c where c.available = true ")
    List<Cars> findByAvailible();



}

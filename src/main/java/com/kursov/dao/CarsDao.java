package com.kursov.dao;

import com.kursov.model.Cars;
import com.kursov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarsDao  extends JpaRepository<Cars, Long> {

    Cars findCarsById(Long id);

    @Query("select c from Cars c where c.available = true ")
    List<Cars> findByAvailible();


/*
    @Query("select b from user_roles b where b.name = :name")
    Role findByName(/*@Param("name")*/ /*String name);
*/
}

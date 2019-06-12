package com.kursov.dao;

import com.kursov.model.Jurnal;
import com.kursov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JurnalDao extends JpaRepository<Jurnal, Long> {

    //@Query("select j from Jurnal j where j.user =:id")
    List<Jurnal> findJurnalByUser_Id(long id);

//    @Query("select u from jurnal j join users u on u.id = j.uesrId where j.carsId = :id and j.eliminDate is null")
//    public User getLastUser(long id);

// ?#{[0]}
    /*

    @Query("select u from User u where u.age = ?#{[0]}")
List findUsersByAge(int age);

@Query("select u from User u where u.firstname = :#{#customer.firstname}")
List findUsersByCustomersFirstname(@Param("customer") Customer customer);
     */

}

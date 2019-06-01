package com.kursov.dao;

import com.kursov.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleDao extends JpaRepository<Role, Long> {

        /*
    @Query("select b from roles b where b.name = :name")
    Role findByName(/*@Param("name")*/ /*String name);
     */


}

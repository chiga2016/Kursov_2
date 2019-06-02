package com.kursov.dao;

import com.kursov.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RoleDao extends JpaRepository<Role, Long> {

        /*
    @Query("select b from user_roles b where b.name = :name")
    Role findByName(/*@Param("name")*/ /*String name);
     */

    /*
    @Query("select r.name from user_roles ur join roles r on r.id = ur.role_id join users u on u.id = ur.user_id  where  u.username =:username ")
    Set<String> rolesSet( String username );
*/

}

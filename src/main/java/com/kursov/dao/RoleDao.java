package com.kursov.dao;

import com.kursov.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface RoleDao extends JpaRepository<Role, Long> {

}

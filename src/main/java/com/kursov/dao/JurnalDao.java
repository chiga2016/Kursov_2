package com.kursov.dao;

import com.kursov.model.Jurnal;
import com.kursov.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JurnalDao extends JpaRepository<Jurnal, Long> {
    List<Jurnal> findJurnalByUser_Id(long id);
}

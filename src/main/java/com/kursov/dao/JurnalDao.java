package com.kursov.dao;

import com.kursov.model.Jurnal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JurnalDao extends JpaRepository<Jurnal, Long> {

}

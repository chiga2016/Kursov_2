package com.kursov.service;

import com.kursov.model.Jurnal;
import com.kursov.model.User;

import java.util.List;

public interface JurnalService {
    void save(Jurnal jurnal );
    List<Jurnal> getJurnalByUser_Id(long id);

//    User getLastUserByCar(long id);
}

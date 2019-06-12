package com.kursov.service;

import com.kursov.dao.JurnalDao;
import com.kursov.model.Jurnal;
import com.kursov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurnalServiceImpl implements JurnalService {
    @Autowired
    JurnalDao jurnalDao;

    @Override
    public void save(Jurnal jurnal) {
        jurnalDao.save(jurnal);
    }

    @Override
    public List<Jurnal> getJurnalByUser_Id(long id) {
        return jurnalDao.findJurnalByUser_Id(id);
    }

//    @Override
//    public User getLastUserByCar(long id) {
//        return jurnalDao.getLastUser(id);
//    }


}

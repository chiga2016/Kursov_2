package com.kursov.controllers;

import com.kursov.dao.HiberDAO;
import com.kursov.model.Jurnal;
import com.kursov.service.HiberService;
import com.kursov.service.JurnalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    private HiberDAO dao;
    @Autowired
    private JurnalService jurnalService;
    @Autowired
    private HiberService hiberService;

    @RequestMapping(value = "delCarToUser/{id}", method = RequestMethod.DELETE,
            produces = {"application/json"})
    String delCarToUser(@PathVariable("id") int id) {
        //dao.delCarToUser(id);
        return  "";
        //List<Cat> allCats = dao.getAllCats();
        // return cat.toString();
    }


    @RequestMapping(value = "jurnal/{id}", method = RequestMethod.GET,
            produces = {"application/json"})
        List<Jurnal> getJurnal(@PathVariable("id") long id) {
        Logger log = LoggerFactory.getLogger(this.getClass());

        log.info("ID = " + Long.toString(id));


        //List<Jurnal> jurnalList = jurnalService.getJurnalByUser_Id(id) ;  //dao.findPerson(id);
        List<Jurnal> jurnalList = hiberService.findJurnalByUserId(id);
//        String res;
//        if(id instanceof Long){ res= "true";} else {res="false";}
//        log.info( res );

        log.info("JURNALLIST" + jurnalList.toString());
        return jurnalList;
    }
}

package com.kursov.controllers;

import com.kursov.dao.HiberDAO;
import com.kursov.exception.CarNotFoundException;
import com.kursov.model.Cars;
import com.kursov.model.Jurnal;
import com.kursov.service.CarsService;
import com.kursov.service.HiberService;
import com.kursov.service.JurnalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    private HiberDAO dao;
    @Autowired
    private JurnalService jurnalService;
    @Autowired
    private HiberService hiberService;
    @Autowired
    private CarsService carsService;

    @RequestMapping(value = "cars", method = RequestMethod.GET,
            produces = {"application/json"})
    float getCostJurnal(@RequestParam("dur") long dur, @RequestParam("car") long car) {
        Logger log = LoggerFactory.getLogger(this.getClass());
        log.info("duration = " + Long.toString(dur)+ "car=" + car);
        float cost = 0;
        try {
            cost = hiberService.calcCost(dur,car);
        } catch (CarNotFoundException e) {
            e.printStackTrace();
        }
        return cost;
    }


    @RequestMapping(value = "jurnal/{id}", method = RequestMethod.GET,
            produces = {"application/json"})
    List<Jurnal> getJurnal(@PathVariable("id") long id) {
        Logger log = LoggerFactory.getLogger(this.getClass());
        log.info("ID = " + Long.toString(id));
        List<Jurnal> jurnalList = hiberService.findJurnalByUserId(id);
        log.info("JURNALLIST" + jurnalList.toString());
        return jurnalList;
    }

}

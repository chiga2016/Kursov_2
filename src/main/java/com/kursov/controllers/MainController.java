
package com.kursov.controllers;

import com.kursov.dao.CarsDao;
import com.kursov.dao.HiberDAO;
import com.kursov.model.Cars;

import java.util.Collections;
import java.util.List;

import com.kursov.model.Jurnal;
import com.kursov.model.User;
import com.kursov.service.CarsService;
import com.kursov.service.HiberService;
import com.kursov.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    HiberDAO dao;
    @Autowired
    HiberService hiberService;
    @Autowired
    UserService userService;
    @Autowired
    CarsService carsService;

    @RequestMapping(value = "addCarToUser", method = RequestMethod.POST)
    public ModelAndView addCarToUser(@ModelAttribute("idUser") String idUser, @ModelAttribute("idCar") String idCar) { //(@PathVariable("idCar") int idCar, @PathVariable("idUser") int idUser ){
        //User user = dao.addCarToUser(Long.parseLong(idUser), Long.parseLong(idCar));
        User user = hiberService.addCarToUser(Long.parseLong(idUser), Long.parseLong(idCar));
        List<Cars> cars = carsService.findByAvailible();
        List<Cars> allCars =  carsService.findAll();
        List<Jurnal> jurnal = hiberService.findJurnalByUserId(Long.parseLong(idUser));
        //log.info(idUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profilePage");
        modelAndView.addObject("u", user);
        modelAndView.addObject("cars", cars);
        modelAndView.addObject("allCars", allCars);
        modelAndView.addObject("jurnal", jurnal );
        return modelAndView;
    }

    @RequestMapping(value = "delCarToUser", method = RequestMethod.POST)
    public ModelAndView delCarToUser(@ModelAttribute("idUser") String idUser) {
        hiberService.delCarToUser(Long.parseLong(idUser));

        User user = userService.findUserById(Long.parseLong(idUser));
        List<Cars> cars = carsService.findByAvailible();
        List<Cars> allCars =  carsService.findAll();
        List<Jurnal> jurnal = hiberService.findJurnalByUserId(Long.parseLong(idUser));
        //log.info(idUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profilePage");
        modelAndView.addObject("u", user);
        modelAndView.addObject("cars", cars);
        modelAndView.addObject("allCars", allCars);
        modelAndView.addObject("jurnal", jurnal );
        return modelAndView;
    }

    @RequestMapping(value = "updateJurnal", method = RequestMethod.POST)
    public ModelAndView updateJurnal(@ModelAttribute("idUser") Long idUser, @ModelAttribute("idCar") Long idCar){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profilePage");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        return new ModelAndView("index");
        // Запрос по точке входа "/" будет выводить нам index.jsp, а найдет он его благодаря нашему dispatcher-servlet
    }
    @RequestMapping(value = "bazaavto", method = RequestMethod.GET)
    public ModelAndView bazaavto(){
        return new ModelAndView("bazaavto").addObject("cars", carsService.findAll());
        // Запрос по точке входа "/" будет выводить нам index.jsp, а найдет он его благодаря нашему dispatcher-servlet
    }

}
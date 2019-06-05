
package com.kursov.controllers;

import com.kursov.dao.CarsDao;
import com.kursov.dao.HiberDAO;
import com.kursov.model.Cars;

import java.util.Collections;
import java.util.List;

import com.kursov.model.User;
import com.kursov.service.CarsService;
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
    UserService userService;
    @Autowired
    CarsService carsService;

    @RequestMapping(value = "addCarToUser", method = RequestMethod.POST)
    public ModelAndView addCarToUser(@ModelAttribute("idUser") String idUser, @ModelAttribute("idCar") String idCar) { //(@PathVariable("idCar") int idCar, @PathVariable("idUser") int idUser ){
        User user = dao.addCarToUser(Long.parseLong(idUser), Long.parseLong(idCar));
        List<Cars> cars = carsService.findByAvailible();
        //log.info(idUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profilePage");
        modelAndView.addObject("u", user);
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

    @RequestMapping(value = "delCarToUser", method = RequestMethod.POST)
    public ModelAndView delCarToUser(@ModelAttribute("idUser") String idUser) {
        dao.delCarToUser(Long.parseLong(idUser));
        User user = userService.findUserById(Long.parseLong(idUser));
        List<Cars> cars = carsService.findByAvailible();
        //log.info(idUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profilePage");
        modelAndView.addObject("u", user);
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

    @RequestMapping(value = "updateJurnal", method = RequestMethod.POST)
    public ModelAndView updateJurnal(@ModelAttribute("idUser") Long idUser, @ModelAttribute("idCar") Long idCar){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profilePage");

        return modelAndView;
    }

    @RequestMapping("/delete/car/{id}")
    public ModelAndView deleteCarId(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("listalldata");
        //Cat c = dao.getCatById(1);
        //Cat c = dao.find(id);
        dao.deleteCar(id);
        //mv.addObject("cats", Collections.singletonList(c));
        List<Cars> allCars = dao.getAllCars();
        mv.addObject("cars", allCars);

        return mv;
        //return showAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
            return new ModelAndView("index");
            // Запрос по точке входа "/" будет выводить нам index.jsp, а найдет он его благодаря нашему dispatcher-servlet
        }

    @RequestMapping(value = "/add/person", method = RequestMethod.POST)
    public ModelAndView  addUser(@ModelAttribute("user") User user)  {
        ModelAndView modelAndView = new ModelAndView();
        // dao.addPerson(person.getFam(), person.getName(), person.getOt(), person.getDr() );
        //dao.addPerson(person);
        //return "afterRegister";
        //return showAll();
        userService.save(user);
        modelAndView.setViewName("admin");
        modelAndView.addObject("cars", carsService.findAll());
        modelAndView.addObject("users",userService.findAll() );
        return modelAndView;
    }


    @RequestMapping(value = "/admin/addcar", method = RequestMethod.POST)
    public ModelAndView addCar(@ModelAttribute("cars") Cars cars)  {
       // dao.addCars(cars.getName(), cars.getModel(), cars.getTransmission(), cars.getYear() );
        ModelAndView modelAndView = new ModelAndView();
        carsService.saveAndFlush(cars);

        modelAndView.setViewName("admin");
        modelAndView.addObject("cars", carsService.findAll());
        modelAndView.addObject("users",userService.findAll() );

        return modelAndView;
    }

    @RequestMapping(value = "/admin/addcar", method = RequestMethod.GET)
    public String addCar(){
        return "addCar";
    }

    @RequestMapping(value = "/admin/adduser", method = RequestMethod.GET)
    public String addUser(){
        return "addUser";
    }


}

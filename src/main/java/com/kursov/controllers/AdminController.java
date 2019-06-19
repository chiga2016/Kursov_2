package com.kursov.controllers;

import com.kursov.dao.CarsDao;
import com.kursov.dao.HiberDAO;
import com.kursov.service.CarsService;
import com.kursov.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    HiberDAO dao;

    @Autowired
    UserService userService;

    @Autowired
    CarsService carsService;
/*
    @Autowired
    CarsDao carsDao;
    @Autowired
    UserDao userDao;
    @Autowired
    CarsDao carsDao;
*/

    @RequestMapping("admin")
    public ModelAndView admin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("users",userService.findAll()); //userDao.findAll());
        modelAndView.addObject("cars", carsService.findAll());

        return modelAndView;
    }

    @RequestMapping(value ="admin/edituser/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        modelAndView.addObject("users",userService.findUserById(id)); //userDao.findAll());

        return modelAndView;
    }

    @RequestMapping(value ="admin/editcar/{id}", method = RequestMethod.GET)
    public ModelAndView editCar(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCar");
        modelAndView.addObject("cars", carsService.findCarsById(id));

        return modelAndView;
    }

}

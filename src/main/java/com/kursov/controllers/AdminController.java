package com.kursov.controllers;

import com.kursov.dao.CarsDao;
import com.kursov.dao.HiberDAO;
import com.kursov.model.Cars;
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
public class AdminController {

    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    HiberDAO dao;

    @Autowired
    UserService userService;

    @Autowired
    CarsService carsService;

    @Autowired
    HiberService hiberService;
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

    @RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
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

    @RequestMapping(value ="admin/edituser/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        modelAndView.addObject("users",userService.findUserById(id)); //userDao.findAll());

        return modelAndView;
    }

    @RequestMapping(value ="admin/edituser", method = RequestMethod.POST)
    public ModelAndView editUserPost(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("users",userService.findAll()); //userDao.findAll());

        return modelAndView;
    }

    @RequestMapping(value ="admin/editcar/{id}", method = RequestMethod.GET)
    public ModelAndView editCar(@PathVariable("id") long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editCar");
        modelAndView.addObject("cars", carsService.findCarsById(id));

        return modelAndView;
    }


    @RequestMapping(value ="admin/editcar", method = RequestMethod.POST)
    public ModelAndView editCarPost(@ModelAttribute("cars") Cars cars){
        ModelAndView modelAndView = new ModelAndView();

        //Cars carsOld = carsService.findCarsById(cars.getId());

        //carsOld = cars;

        //hiberService.updateCar(carsOld);


        modelAndView.setViewName("admin");
        modelAndView.addObject("cars", carsService.findAll());

        return modelAndView;
    }
}

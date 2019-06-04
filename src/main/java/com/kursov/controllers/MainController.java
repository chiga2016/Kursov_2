
package com.kursov.controllers;

import com.kursov.dao.CarsDao;
import com.kursov.dao.HiberDAO;
import com.kursov.dao.UserDao;
import com.kursov.model.Cars;

import java.util.Collections;
import java.util.List;

import com.kursov.model.Person;
import com.kursov.model.User;
import com.kursov.service.CarsService;
import com.kursov.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


@Controller
public class MainController {
    
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HiberDAO dao;

    @Autowired
    UserService userService;

//    @Autowired
//    @Qualifier(value = "carsService")
//    CarsService carsService;

    @Autowired
    CarsDao carsDao;


   /* @Autowired
    UserDao userDao;
    @Autowired
    CarsDao carsDao;
*/

    
    @ModelAttribute("status")
    public String getStatus() {
        return dao.pullStatus();
    }
    
    @RequestMapping("list.do")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("listalldata");
        List<Cars> allCars = dao.getAllCars();
        mv.addObject("cars", allCars);
        log.info(allCars.toString());
        return mv;              
    }
    
    @RequestMapping("showCar.do")
    public ModelAndView showOne(long id) {
        ModelAndView mv = new ModelAndView("showCars");
        //Cat c = dao.getCatById(1);

        Cars c = dao.findCar(id);
        mv.addObject("cars", Collections.singletonList(c));
        //mv.addObject("persons", dao.getAllPersons());
        return mv;              
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

    @RequestMapping("/delete/person/{id}")
    public ModelAndView deletePersonId(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("listalldata");
        //Cat c = dao.getCatById(1);
        //Cat c = dao.find(id);
       dao.deletePerson(id);
        //mv.addObject("cats", Collections.singletonList(c));
        List<Cars> allCars = dao.getAllCars();
        //List<Person> allPersons = dao.getAllPersons();
        //mv.addObject("persons", allPersons);

        return mv;
        //return showAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
            return new ModelAndView("index");
            // Запрос по точке входа "/" будет выводить нам index.jsp, а найдет он его благодаря нашему dispatcher-servlet
        }

        
    @RequestMapping("init.do")
    public String init() {
        dao.init();
        return "redirect:list.do";
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
        modelAndView.addObject("cars", carsDao.findAll());
        modelAndView.addObject("users",userService.findAll() );


        return modelAndView;
    }


    @RequestMapping(value = "/admin/addcar", method = RequestMethod.POST)
    public ModelAndView addCar(@ModelAttribute("cars") Cars cars)  {
       // dao.addCars(cars.getName(), cars.getModel(), cars.getTransmission(), cars.getYear() );
        ModelAndView modelAndView = new ModelAndView();
        carsDao.saveAndFlush(cars);

        modelAndView.setViewName("admin");
        modelAndView.addObject("cars", carsDao.findAll());
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

    @RequestMapping("login.do")
    public String login(){
        return "login";
    }


    @RequestMapping("register.do")
    public String addPerson(){
        return "register";
    }



    @RequestMapping("changeOwner.do")
    public ModelAndView changeOwner(long pid, long cid) {
        ModelAndView mv = new ModelAndView("listalldata");

        dao.changePerson(pid, cid);
        //Cat c = dao.getCatById(1);
//        Cat c = dao.findCat(cid);
//        Person p = dao.findPerson(pid);
//        c.setOwner(p);
        //dao.deletePerson(id);
        //mv.addObject("cats", Collections.singletonList(c));
        List<Cars> allCars = dao.getAllCars();
        //List<Person> allPersons = dao.getAllPersons();
        //mv.addObject("persons", allPersons);

        mv.addObject("cats", allCars);
        return mv;
        //return showAll();
    }

    @RequestMapping(value = "addCarToUser", method = RequestMethod.POST)
    public ModelAndView addCarToUser(@ModelAttribute("idUser") String idUser, @ModelAttribute("idCar") String idCar) { //(@PathVariable("idCar") int idCar, @PathVariable("idUser") int idUser ){
       User user = dao.addCarToUser(Long.parseLong(idUser), Long.parseLong(idCar));
       List<Cars> cars = carsDao.findByAvailible();
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
        List<Cars> cars = carsDao.findByAvailible();
        //log.info(idUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profilePage");
        modelAndView.addObject("u", user);
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

    //
    

    
    
    
    
}

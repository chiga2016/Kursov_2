package com.kursov.controllers;

import com.kursov.dao.CarsDao;
import com.kursov.dao.HiberDAO;
import com.kursov.exception.CarNotFoundException;
import com.kursov.exception.UserNotFoundException;
import com.kursov.model.Cars;
import com.kursov.model.User;
import com.kursov.service.CarsService;
import com.kursov.service.HiberService;
import com.kursov.service.UserService;
import com.kursov.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    Logger log = LoggerFactory.getLogger(this.getClass());
    //    @Autowired
//    HiberDAO dao;
    @Autowired
    UserService userService;
    @Autowired
    CarsService carsService;
    @Autowired
    HiberService hiberService;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping("admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("users", userService.findAll()); //userDao.findAll());
        modelAndView.addObject("cars", carsService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        userValidator.validate(userForm, bindingResult);
        modelAndView.setViewName("admin");
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("cars", carsService.findAll());
            modelAndView.addObject("users", userService.findAll());
            return modelAndView;
        }
        userService.save(userForm);
        modelAndView.addObject("cars", carsService.findAll());
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addcar", method = RequestMethod.POST)
    public ModelAndView addCar(@ModelAttribute("cars") Cars cars) {
        ModelAndView modelAndView = new ModelAndView();
        log.info("INFOCAR " + cars.toString());
        String img = "/resources/img/" + cars.getImg();
        cars.setImg(img);
        log.info("IMG  = " + img);
        carsService.saveAndFlush(cars);
        modelAndView.setViewName("admin");
        modelAndView.addObject("cars", carsService.findAll());
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addcar", method = RequestMethod.GET)
    public String addCar() {
        return "addCar";
    }

//    @RequestMapping(value = "/admin/adduser", method = RequestMethod.GET)
//    public String addUser(){
//        return "addUser";
//    }

    @RequestMapping(value = "/admin/adduser", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("userForm", new User());
        return "addUser";
    }

    @RequestMapping(value = "admin/edituser/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") long id, ModelAndView modelAndView) {
        modelAndView.setViewName("editUser");
       // try {
            modelAndView.addObject("userForm", userService.findUserById(id)); //userDao.findAll());
//        } catch (UserNotFoundException e) {
//            e.printStackTrace();
//            modelAndView.setViewName("errorPage");
//            modelAndView.addObject("message", e.getMessage());
//        }
        return modelAndView;
    }

    @RequestMapping(value = "admin/edituser", method = RequestMethod.POST)
    public ModelAndView editUserPost(@ModelAttribute("userForm") User userForm, BindingResult bindingResult/*, Model model*/) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        logger.info("НА АДМИН КОНТРОЛЛЕР ПРИШЛО ЗАДАНИЕ ОТРЕДАКТИРОВАТЬ ПОЛЬЗОВАТЕЛЯ С ИД" + userForm.getId());

        userValidator.validateFIO(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            log.info("ВАЛИДАЦИЯ НЕ ПРОЙДЕНА!!!!!!!!!!");
            log.info(bindingResult.toString());
            ModelAndView modelAndView2 = new ModelAndView();
            modelAndView2.setViewName("editUser");
            return modelAndView2;
        } else {
            //try {
                hiberService.updateUser(userForm, bindingResult);
           // } catch (UserNotFoundException e) {
//                e.printStackTrace();
//                modelAndView.setViewName("errorPage");
//                modelAndView.addObject("message", e.getMessage());
//            }
        }
        modelAndView.addObject("cars", carsService.findAll());
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;

    }

    @RequestMapping(value = "admin/editcar/{id}", method = RequestMethod.GET)
    public ModelAndView editCar(@PathVariable("id") long id, ModelAndView modelAndView) {
        //ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("editCar");
        modelAndView.addObject("cars", carsService.findCarsById(id));
        return modelAndView;
    }

    @RequestMapping(value = "admin/editcar", method = RequestMethod.POST)
    public ModelAndView editCarPost(@ModelAttribute("cars") Cars cars) {
        ModelAndView modelAndView = new ModelAndView();
        //Cars carsOld = carsService.findCarsById(cars.getId());
        //carsOld = cars;
        hiberService.updateCar(cars);
        modelAndView.setViewName("admin");
        modelAndView.addObject("cars", carsService.findAll());
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @ExceptionHandler({CarNotFoundException.class, UserNotFoundException.class})
    public ModelAndView notFound(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        e.printStackTrace();
        modelAndView.setViewName("errorPage");
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;
    }

}

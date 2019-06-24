package com.kursov.controllers;

import com.kursov.dao.CarsDao;
import com.kursov.dao.HiberDAO;
import com.kursov.model.Cars;
import com.kursov.model.Jurnal;
import com.kursov.model.User;
import com.kursov.service.CarsService;
import com.kursov.service.HiberService;
import com.kursov.service.SecurityService;
import com.kursov.service.UserService;
import com.kursov.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private CarsService carsService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    HiberService hiberService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }
        return "login";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public ModelAndView welcome() {
        ModelAndView modelAndView= new  ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth!=null) {
            String username = auth.getName();
            if(username=="admin"){
                modelAndView.setViewName("redirect:/admin");
                return modelAndView;
            }
            else {
                modelAndView.setViewName("profilePage");
                User user = userService.findUserByUsername(username);
                //User user = userService.findByUsername(username);
                // Set<String> setRoles = roleDao.rolesSet(auth.getName());
                modelAndView.addObject("u", user);
                modelAndView.addObject("ustring", user.toString());
                //  modelAndView.addObject("roles", setRoles );
                List<Cars> cars =  carsService.findByAvailible();
                modelAndView.addObject("cars", cars);

                List<Cars> allCars =  carsService.findAll();
                modelAndView.addObject("allCars", allCars);

                List<Jurnal> jurnal = hiberService.findJurnalByUserId(user.getId());
                modelAndView.addObject("jurnal", jurnal );
            }
        }
        else {
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

//    @RequestMapping(value = "/showUsers", method = RequestMethod.GET)
//    public ModelAndView showUsers() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("showUsers");
//        List<User> users = userService.findAll();
//        modelAndView.addObject("users",users);
//
//        return modelAndView;
//    }
}
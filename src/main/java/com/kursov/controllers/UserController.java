package com.kursov.controllers;

import com.kursov.dao.HiberDAO;
import com.kursov.model.Person;
import com.kursov.model.User;
import com.kursov.service.SecurityService;
import com.kursov.service.SecurityServiceImpl;
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


@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    HiberDAO dao;

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

        logger.info(userForm.getConfirmPassword());
        logger.info(securityService.findLoggedInUsername()) ;
        logger.info(auth.toString());
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

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public ModelAndView welcome() {
      ModelAndView modelAndView= new  ModelAndView("profilePage");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.findByUsername(username);
        modelAndView.addObject("u",user);
        modelAndView.addObject("ustring", user.toString());
       return modelAndView;
    }
//    public ModelAndView welcome(){
//        ModelAndView m = new ModelAndView("profilePage");
//        String username = securityService.findLoggedInUsername();
//        User user = userService.findByUsername(username);
//        m.addObject("fam", user.getFam());
//
//        return m;
//    }



    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
}

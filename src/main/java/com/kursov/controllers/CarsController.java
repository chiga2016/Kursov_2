package com.kursov.controllers;

import com.kursov.dao.CarsDao;
import com.kursov.exception.CarNotFoundException;
import com.kursov.model.Cars;
import com.kursov.service.CarsService;
import com.kursov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CarsController {

    @Autowired
    CarsService carsService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/cars/{idCar}",method = RequestMethod.GET)
    ModelAndView cars (@PathVariable String idCar){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView();
        try {modelAndView.setViewName("/carPage");
        Cars car = null;

            car = carsService.findCarsById(Long.parseLong(idCar));

        modelAndView.addObject("car", car);
        modelAndView.addObject("user", userService.findUserByUsername(auth.getName()) );
        modelAndView.addObject("currentDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        modelAndView.addObject("currentTime", new SimpleDateFormat("HH:mm").format(new Date()));
        modelAndView.addObject("futureTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()+1000*3600));
    } catch (CarNotFoundException e) {
            e.printStackTrace();
            modelAndView.setViewName("errorPage");
            modelAndView.addObject("message", e.getMessage());
    }
        return modelAndView;

    }

}

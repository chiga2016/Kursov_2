package com.kursov.controllers;

import com.kursov.dao.HiberDAO;
import com.kursov.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @Autowired
    com.kursov.model.CurrentUserBean ub;
    @Autowired
    HiberDAO dao;

    //  @ModelAttribute(name="user") // без name не заработает, выберет имя сам
    public String getUser() {
        return ub.getUsername();
    }

    @RequestMapping(value="login")
    public String login() {
        return "login";
    }


    @RequestMapping(value="login.do",method=RequestMethod.POST)
//public String login( @RequestParam(required=true) String u, @RequestParam(required=true) String p  ) {
    public ModelAndView login(@RequestParam(value="login") String u, @RequestParam(value="pass") String p){
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("profilePage");
            Person person = dao.findPersonByUsername(u);
            modelAndView.addObject("x", person);
        }
        catch(Exception ex)
        {
            modelAndView.setViewName("redirect:errorLogin");
        }
    /*
    ModelAndView modelAndView = new ModelAndView("profilePage");
    Person person = dao.findPerson(2L);
    //String result="";
        if(ub.login(u,p)){
            //result=  "redirect:profile";
            modelAndView.addObject("login", u);
            //LOG.info("test start");
            //LOG.info("test end");
            modelAndView.addObject("x", person);
        }
        else{
            throw  new Login1Exception("fail");
            //result=  "redirect:errorLogin";
        }
 */
        return  modelAndView;

    }

    @RequestMapping(value="logout.do")
    public String logout(Model m) {
        ub.setUsername(null);
        return  "redirect:index";
    }

}

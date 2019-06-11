package com.kursov.controllers;

import com.kursov.dao.HiberDAO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    private HiberDAO dao;

    @RequestMapping(value = "delCarToUser/{id}", method = RequestMethod.DELETE,
            produces = {"application/json"})
    String delCarToUser(@PathVariable("id") int id) {
        //dao.delCarToUser(id);
        return  "";
        //List<Cat> allCats = dao.getAllCats();
        // return cat.toString();
    }

}

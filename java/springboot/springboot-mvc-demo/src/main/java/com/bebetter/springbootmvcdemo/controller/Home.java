package com.bebetter.springbootmvcdemo.controller;

import com.bebetter.springbootmvcdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    String home() {
        return "Hello Spring Boot";
    }

    @RequestMapping("/r")
    String retrieve(Model model){
        model.addAttribute("users",userDao.selectAll());
        return "index";
    }
}

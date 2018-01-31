package com.bebetter.web.controller;

import com.bebetter.po.Role;
import com.bebetter.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class IndexController {
    @Resource
    private User user;
    @Resource
    private Role role;

    private ModelAndView getData() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.addObject("role", role);

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"", "/"})
    public String toIndex() {
        return "index";
    }

    @RequestMapping(value = "/data/user")
    public ModelAndView toUser() {
        return getData();
    }

    @RequestMapping(value = "/data/role")
    public ModelAndView toRole() {
        return getData();
    }

}

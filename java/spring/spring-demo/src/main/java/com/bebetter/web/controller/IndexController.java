package com.bebetter.web.controller;

import com.bebetter.po.RolePo;
import com.bebetter.po.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class IndexController {
    // 已经定义的bean可以使用autowired或者resource等注解调用。常用于同一个类使用同一个bean。
    @Resource
    private RolePo rolePo1;
    @Autowired
    private RolePo rolePo2;

    @Autowired(required = true)
    private UserPo userPo1;

    private ModelAndView getData() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userPo1);
        modelAndView.addObject("role", rolePo1);

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"", "/"})
    public String toIndex() {
        System.out.println(rolePo1.toString());
        System.out.println(rolePo2.toString());
        System.out.println(userPo1.toString());
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

package com.bebetter.web.controller;

import com.bebetter.po.RolePo;
import com.bebetter.po.UserPo;
import com.bebetter.service.RoleService;
import com.bebetter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    private ModelAndView getData() {
        ModelAndView modelAndView = new ModelAndView();
        List<UserPo> userPoList = userService.getAll();
        if (null == userPoList || userPoList.isEmpty()) {
            userService.add();
        }
        userPoList = userService.getAll();
        modelAndView.addObject("user", userPoList.get(0));
        modelAndView.addObject("role", roleService.getByName(userPoList.get(0).getRoleName()));

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

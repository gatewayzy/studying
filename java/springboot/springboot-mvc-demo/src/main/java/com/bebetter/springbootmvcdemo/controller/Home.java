package com.bebetter.springbootmvcdemo.controller;

import com.bebetter.springbootmvcdemo.dao.UserDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Home {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    String home() {
        return "redirect:/r";
    }

    @RequestMapping("/r")
    String retrieve(Model model) {
        model.addAttribute("users", userDao.selectAll());
        return "index";
    }

    @RequestMapping("/ajaxget")
    @ResponseBody
    String ajaxGet(@RequestParam(name = "id") int id) {
        System.out.println("GET获取数据 id=" + id);
        return new Gson().toJson(userDao.selectById(id));
    }

    @RequestMapping("/ajaxpost")
    @ResponseBody
    String ajaxPost(@RequestParam(name = "id") int id) {
        System.out.println("使用POST方法获取数据 id=" + id);
        return new Gson().toJson(userDao.selectById(id));
    }

}

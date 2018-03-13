package com.bebetter.springbootmvcdemo.JPADemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RoleWebController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RoleDao roleDao;

    @RequestMapping("/role/{id}")
    public Role role(@PathVariable Long id) {
        Optional<Role> roleOptional = roleDao.findById(id);
        System.out.println(roleOptional.isPresent());
        return roleService.findById(id);
    }
}

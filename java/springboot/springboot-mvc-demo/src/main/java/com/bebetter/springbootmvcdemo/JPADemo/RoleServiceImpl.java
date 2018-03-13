package com.bebetter.springbootmvcdemo.JPADemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findById(long id) {
        return roleDao.findById(id).get();
    }
}

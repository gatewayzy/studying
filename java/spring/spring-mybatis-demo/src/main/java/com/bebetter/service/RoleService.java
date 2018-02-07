package com.bebetter.service;

import com.bebetter.po.RolePo;

public interface RoleService {
    RolePo add();

    RolePo getById(int id);
    RolePo getByName(String name);
}

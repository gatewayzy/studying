package com.bebetter.service.impl;

import com.bebetter.dao.RoleDao;
import com.bebetter.po.RolePo;
import com.bebetter.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    @Override
    public RolePo add() {
        String name = String.format("role_%d", System.currentTimeMillis());
        RolePo rolePo = new RolePo(-1, name);
        roleDao.insert(rolePo);
        System.out.print("生成一条随机role数据，信息为：");
        rolePo.print();
        return rolePo;
    }

    @Override
    public RolePo getById(int id) {
        List<Integer> idList = new ArrayList<>();
        idList.add(id);
        return roleDao.selectById(idList).get(0);
    }

    @Override
    public RolePo getByName(String name) {
        List<String> nameList = new ArrayList<>();
        nameList.add(name);
        return roleDao.selectByName(nameList).get(0);
    }

}

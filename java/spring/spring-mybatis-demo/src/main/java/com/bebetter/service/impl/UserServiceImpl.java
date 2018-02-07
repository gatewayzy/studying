package com.bebetter.service.impl;

import com.bebetter.dao.RoleDao;
import com.bebetter.dao.UserDao;
import com.bebetter.po.RolePo;
import com.bebetter.po.UserPo;
import com.bebetter.service.RoleService;
import com.bebetter.service.UserService;
import com.googlecode.ehcache.annotations.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private RoleService roleService;

    @Override
    public int add() {
        HashMap<String, Object> map = new HashMap<>();
        String name = String.format("user_%d", System.currentTimeMillis());
        map.put("name", name);
        RolePo rolePo = roleService.add();
        map.put("roleName", rolePo.getName());
        return userDao.insert(map);
    }

    // 将本方法的结果使用ehcache缓存
    @Override
    @Cacheable(cacheName = "userCache")
    public List<UserPo> getAll() {
        List<UserPo> res = new ArrayList<>();
        List<HashMap<String, Object>> list = userDao.selectAll();
        list.forEach(t -> {
            res.add(new UserPo((int) t.get("id"), (String) t.get("name"), (String) t.get("roleName")));
        });
        return res;
    }
}

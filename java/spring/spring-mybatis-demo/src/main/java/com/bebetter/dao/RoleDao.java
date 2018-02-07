package com.bebetter.dao;

import com.bebetter.po.RolePo;

import java.util.List;

public interface RoleDao {
    int insert(RolePo rolePo);

    List<RolePo> selectById(List<Integer> list);

    List<RolePo> selectByName(List<String> list);

    List<RolePo> selectAll();

    int update(RolePo rolePo);

    int delete(List<Integer> list);

}

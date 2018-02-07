package com.bebetter.dao;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    int insert(HashMap map);

    List<HashMap<String,Object>> selectById(List<Integer> list);

    List<HashMap<String,Object>> selectAll();

    int update(HashMap<String,Object> map);

    int delete(List<Integer> list);
}

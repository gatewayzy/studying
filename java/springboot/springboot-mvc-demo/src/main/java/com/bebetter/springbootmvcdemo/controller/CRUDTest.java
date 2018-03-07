package com.bebetter.springbootmvcdemo.controller;

import com.bebetter.springbootmvcdemo.dao.UserDao;
import com.bebetter.springbootmvcdemo.po.UserPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 对数据库进行CRUD测试。运行时，使用junit测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void insert() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "springboot");
        System.out.println(String.format("\n===========\n成功插入：%d条数据\n", userDao.insert(map)));
    }

    @Test
    public void retrieveSet() {
        Integer[] id = {1, 6, 7};
        List<Integer> idList = Arrays.asList(id);
        List<HashMap<String, Object>> res = userDao.selectById(idList);
        System.out.println(String.format("\n===========\n成功获取：%d条数据", res.size()));
        res.forEach(t -> {
            System.out.println(t.get("id") + " " + t.get("name"));
        });
    }

    @Test
    public void retrieveAll(){
        List<UserPo> userPos = userDao.selectAll();
        System.out.println(String.format("\n===========\n成功获取：%d条数据", userPos.size()));
        userPos.forEach(t->{
            System.out.println(String.format("%s %s",t.getId(),t.getName()));
        });
    }

    @Test
    public void update(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 7);
        map.put("name", "springboot-7");
        map.put("roleName", "springboot-7");
        System.out.println(String.format("\n===========\n成功修改：%d条数据\n", userDao.update(map)));
    }

    @Test
    public void delete(){
        System.out.println(String.format("\n===========\n成功删除：%d条数据\n", userDao.delete(8)));
    }

}

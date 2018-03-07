package com.bebetter.springbootmvcdemo.controller;

import com.bebetter.springbootmvcdemo.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * 对数据库进行事务测试。注意：一旦使用@Transactional，不管@Test是否成功，@Test都会被rollback。
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TxTest {
    @Autowired
    private UserDao userDao;

    /**
     * 未使用事务管理（针对未使用全局事务）
     */
    @Test
    public void transactionTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 7);
        map.put("name", "springboot-7-err");
        map.put("roleName", "springboot-7-err");
        userDao.update(map);
        String string = null;
        // 发生异常，但是已修改的数据无法恢复
        if (string.equals("")) {
            System.out.println();
        }
    }

    @Test
    @Transactional(rollbackFor = AssertionError.class)
    public void transactionTest1() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 7);
        map.put("name", "s");
        map.put("roleName", "s");
        userDao.update(map);
        // 发生异常，数据回滚
        Assert.assertEquals(1, 2);
        System.out.println("@Test中的事务总是会回滚，不会对数据产生影响");
    }
}

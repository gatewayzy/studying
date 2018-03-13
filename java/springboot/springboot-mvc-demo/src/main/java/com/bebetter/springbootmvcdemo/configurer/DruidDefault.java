package com.bebetter.springbootmvcdemo.configurer;

import com.bebetter.springbootmvcdemo.JPADemo.Role;
import com.bebetter.springbootmvcdemo.JPADemo.RoleDao;
import com.bebetter.springbootmvcdemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("dev") //测试环境下对数据库预处理
public class DruidDefault {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Value("${spring.datasource.url}")
    private String dbURL;

    @PostConstruct
    void init() {
        // 输出所有数据
        userDao.selectAll().forEach(t -> {
            System.out.println(t.getId() + "\t" + t.getName());
        });
        // 更改第一条数据
        roleDao.save(new Role(1, "rold_jpa1"));
        System.out.println("所用数据库地址为："+dbURL);
    }

}

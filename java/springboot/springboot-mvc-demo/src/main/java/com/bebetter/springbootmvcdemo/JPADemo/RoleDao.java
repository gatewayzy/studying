package com.bebetter.springbootmvcdemo.JPADemo;

import org.springframework.data.repository.CrudRepository;

/**
 * 在JPA中，CrudRepository常常返回Optional类型，所以常在Service层进行解析、封装
 */
public interface RoleDao  extends CrudRepository<Role,Long>{
}

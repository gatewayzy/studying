package com.bebetter.mybatisdemo.dao;

import com.bebetter.mybatisdemo.po.UserPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.HashMap;
import java.util.List;

/**
 * 使用Mybatis的注解方式，而不使用xml配置方式：
 * 0. 对接口的方法进行注解
 * 0. sql语法类似于xml，使用<script>拼接复杂语句
 * 0. 在Mybatis中，支持Po、Map传递数据，支持简单xml、高级xml等语句，这里只是示例。
 */

@Mapper
public interface UserDao {

    @Insert("insert into users(user_name, role_name) values (#{name}, #{roleName})")
    int insert(HashMap map);

    @Select("<script>" +
            "select user_id id, user_name name from users where user_id in " +
            "<foreach collection='list' index='index' item='item' open='(' separator=',' close=')'> #{item} </foreach>" +
            "</script>")
    List<HashMap<String, Object>> selectById(List<Integer> idList);

    @Results({@Result(property = "id", column = "user_id",jdbcType = JdbcType.INTEGER),
            @Result(property = "name", column = "user_name")})
    @Select("select user_id id, user_name name from users")
    List<UserPo> selectAll();

    @Update("UPDATE users SET user_name = #{name}, role_name = #{roleName} WHERE user_id = #{id}")
    int update(HashMap<String, Object> map);

    @Delete("DELETE FROM users WHERE user_id = #{id}")
    int delete(int id);
}

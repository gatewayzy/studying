package com.bebetter.dao.impl;

import com.bebetter.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    // 使用定义好的bean访问数据库
    @Resource
    private SqlSession sqlSession;


    @Override
    public int insert(HashMap map) {
        return sqlSession.insert("userDao.insert", map);
    }

    @Override
    public List<HashMap<String,Object>> selectById(List<Integer> list) {
        return sqlSession.selectList("userDao.selectById", list);
    }

    @Override
    public List<HashMap<String,Object>> selectAll() {
        return sqlSession.selectList("userDao.selectAll");
    }

    @Override
    public int update(HashMap map) {
        return sqlSession.update("userDao.update", map);
    }

    @Override
    public int delete(List<Integer> list) {
        return sqlSession.delete("userDao.delete", list);
    }
}

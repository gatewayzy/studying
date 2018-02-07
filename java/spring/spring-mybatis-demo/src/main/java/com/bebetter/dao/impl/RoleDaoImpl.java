package com.bebetter.dao.impl;

import com.bebetter.dao.RoleDao;
import com.bebetter.po.RolePo;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Resource
    private SqlSession sqlSession;

    @Override
    public int insert(RolePo rolePo) {
        return sqlSession.insert("roleDao.insert",rolePo);
    }

    @Override
    public List<RolePo> selectById(List<Integer> list) {
        return sqlSession.selectList("roleDao.selectById",list);
    }

    @Override
    public List<RolePo> selectByName(List<String> list) {
        return sqlSession.selectList("roleDao.selectByName",list);
    }

    @Override
    public List<RolePo> selectAll() {
        return sqlSession.selectList("roleDao.selectAll");
    }

    @Override
    public int update(RolePo rolePo) {
        return sqlSession.update("roleDao.update",rolePo);
    }

    @Override
    public int delete(List<Integer> list) {
        return sqlSession.delete("roleDao.delete",list);
    }
}

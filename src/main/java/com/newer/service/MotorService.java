package com.newer.service;

import com.newer.domain.Motorcycle;
import com.newer.mapper.MotorMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MotorService {

    private MotorMapper motorMapper;
    private SqlSession sqlSession;

    public void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        motorMapper=sqlSession.getMapper(MotorMapper.class);
    }
    public List<Motorcycle> findAll(){
        init();
        List<Motorcycle> motorcycles=motorMapper.findAll();
        SqlSessionUtil.close(sqlSession);
        return motorcycles;
    }
}

package com.newer.service;

import com.newer.domain.Buytable;
import com.newer.mapper.BuytableMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BuytableService {

    private SqlSession sqlSession;
    private BuytableMapper buytableMapper;
    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        buytableMapper=sqlSession.getMapper(BuytableMapper.class);
    }
    //buytable表查所有
    public List<Buytable> findAllBuytable(){
        init();
        List<Buytable> list=buytableMapper.findAllBuytable();
        SqlSessionUtil.close(sqlSession);
        return list;
    }
    //增加采购单表
    public int addBuytable(Buytable buytable){
        init();
        int row=buytableMapper.addBuytable(buytable);
        System.out.print(row+"-------");
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return row;
    }
}

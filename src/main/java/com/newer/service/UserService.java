package com.newer.service;

import com.newer.domain.User;
import com.newer.mapper.UserMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    private SqlSession sqlSession;
    private UserMapper userMapper;

    /**
     * 初始化
     */
    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        userMapper=sqlSession.getMapper(UserMapper.class);
    }

    /**
     * 根据用户名查询用户
     * @param uname
     * @return
     */
    public User findByUname(String uname){
        init();
        User user=new User();
        user=userMapper.findByUname(uname);
        SqlSessionUtil.close(sqlSession);
        return user;
    }

    /**
     * 根据用户id修改密码
     * @param uid
     * @param pwd
     * @return
     */
    public int updatePwd(int uid ,String pwd){
        init();
        int count=userMapper.updatePwd(uid,pwd);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return count;
    }
}

package com.newer.mapper;

import com.newer.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("select * from user where username=#{uname}")
    User findByUname(@Param("uname") String uname);

    @Update("update user set pwd=#{pwd} where uid=#{uid}")
    int updatePwd(@Param("uid") int uid, @Param("pwd") String pwd);
}

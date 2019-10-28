package com.newer.mapper;

import com.newer.domain.Buytable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BuytableMapper {
    @Select("select * from buytable")
    List<Buytable> findAllBuytable();

    @Insert("insert into butable values(#{buyId},#{fname},#{uid}," +
            "#{indentTime},#{uname},#{payerTime},#{incomeTime},#{dprice},#{number},#{zprice},#{alterTime}," +
            "#{indentType},#{remark1})")
    int addBuytable(Buytable buytable);
}

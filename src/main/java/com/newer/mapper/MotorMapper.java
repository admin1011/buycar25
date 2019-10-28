package com.newer.mapper;

import com.newer.domain.Motorcycle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MotorMapper {

    @Select("select * from carmold")
    List<Motorcycle> findAll();
}

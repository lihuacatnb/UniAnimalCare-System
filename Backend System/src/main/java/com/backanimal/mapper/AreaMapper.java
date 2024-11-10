package com.backanimal.mapper;

import com.backanimal.config.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AreaMapper {

    @Select("select name, number, manager from area")
    List<Area> seleAllarea();
}

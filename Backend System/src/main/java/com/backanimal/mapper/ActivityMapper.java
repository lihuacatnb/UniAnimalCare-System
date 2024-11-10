package com.backanimal.mapper;

import com.backanimal.config.Activity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ActivityMapper
{
    @Select("select name, program,manager from activity")
    List<Activity> seleAllactivity();

    @Select("select name, program from activity where name = #{name}")
    Activity selectActivity(@Param("name") String name);

    @Insert("insert into activity(name, program, manager) " +
            "values(#{name}, #{program}, #{manager})")
    int saveActivity(@Param("name") String name,
                 @Param("program") String program,
                 @Param("manager") String manager);

    @Delete("delete from activity where name=#{name}")
    int deleteActivity(@Param("name") String name);

    @Update("update activity set program=#{program} where name=#{name}")
    int resiveActivity1(@Param("name") String name,@Param("program") String program);

    @Update("update activity  set manager=#{manager} where name=#{name}")
    int resiveActivity2(@Param("name") String name,@Param("manager") String manager);
}

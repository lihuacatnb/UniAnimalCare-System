package com.backanimal.mapper;

import com.backanimal.config.Animal;;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AnimalMapper
{
    @Select("select name, type, area,situation from animal")
    List<Animal> seleAllanimal();

    @Insert("insert into animal(name, type, area, situation) " +
            "values(#{name}, #{type}, #{area}, #{situation})")
    int saveAnimal(@Param("name") String name,
                 @Param("type") String type,
                 @Param("area") String area,
                 @Param("situation") String situation);

    @Select("select name, type from animal where name = #{name} and type=#{type}")
    Animal selectanimal(@Param("name") String name,@Param("type") String type);

    @Delete("delete from animal where name=#{name}")
    int deleteAnimal(@Param("name") String name);

    @Update("update animal set area=#{area} where name=#{name}")
    int resiveAnimal1(@Param("name") String name,@Param("area") String area);

    @Update("update animal  set situation=#{situation} where name=#{name}")
    int resiveAnimal2(@Param("name") String name,@Param("situation") String situation);
}

package com.projectanimal.mapper;

import com.projectanimal.config.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper
{
    @Insert("insert into animal_users(name, number, email, password) " +
            "values(#{name}, #{number}, #{email}, #{password})")
    int saveUser(@Param("name") String name,
                 @Param("number") String number,
                 @Param("email") String email,
                 @Param("password") String password);

    @Select("select name, email, password from animal_users where number = #{number}")
    User selectUserNumber(@Param("number") String number);

}

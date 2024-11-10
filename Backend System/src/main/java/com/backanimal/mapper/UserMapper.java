package com.backanimal.mapper;

import com.backanimal.config.User;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface UserMapper
{
    @Insert("insert into animal_users(name, number, email, password) " +
            "values(#{name}, #{number}, #{email}, #{password})")
    int saveUser(@Param("name") String name,
                 @Param("number") String number,
                 @Param("email") String email,
                 @Param("password") String password);

    @Select("select name, number from animal_users where number = #{number}")
    User selectUserNumber(@Param("number") String number);

    @Select("select name, number,email from animal_users")
    List<User> seleAllvolunteer();

    @Delete("delete from animal_users where email=#{email}")
    int deleteVolunteer(@Param("email") String email);

    @Update("update animal_users  set number=#{number} where email=#{email}")
    int resiveVolunteer1(@Param("email") String email,@Param("number") String number);

    @Update("update animal_users  set name=#{name} where email=#{email}")
    int resiveVolunteer2(@Param("email") String email,@Param("name") String name);

}

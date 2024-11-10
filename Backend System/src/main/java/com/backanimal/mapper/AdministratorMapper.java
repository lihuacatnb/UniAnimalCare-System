package com.backanimal.mapper;

import com.backanimal.config.Animal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import  com.backanimal.config.Administrator;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdministratorMapper
{
    @Select("select email, password from Administrator where email = #{email} and password = #{password}")
    Administrator loginAdministrator(@Param("email") String email, @Param("password") String password);

    @Delete("delete from Administrator where email=#{email}")
    int deleteAdministrator(@Param("email") String email);

    @Update("update Administrator set password=#{password} where email=#{email}")
    int resiveAdministrator(@Param("email") String email,@Param("password") String password);

    @Select("select name, number, position from administrator")
    List<Administrator> seleAlladmin();
}

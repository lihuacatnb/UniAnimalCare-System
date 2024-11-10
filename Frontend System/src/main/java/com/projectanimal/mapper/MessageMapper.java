package com.projectanimal.mapper;

import com.projectanimal.config.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper
{
    @Insert("insert into message(content) values(#{content})")
    int saveMessage(@Param("content") String content);

    @Select("select * from message order by id desc limit 5")
    List<Message> selectMore();

    @Select("select id from message where content = #{content}")
    Message selectMessageContent(@Param("content") String content);

}
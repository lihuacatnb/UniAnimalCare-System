package com.backanimal.mapper;

import com.backanimal.config.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper
{

    @Select("select * from message")
    List<Message> selectAllmessage();

    @Delete("delete from message where content=#{content}")
    int deleteMessage(@Param("content") String content);
}
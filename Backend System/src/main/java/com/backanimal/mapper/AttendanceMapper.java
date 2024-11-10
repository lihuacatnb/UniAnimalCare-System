package com.backanimal.mapper;

import com.backanimal.config.Attendance;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttendanceMapper {
    @Select("select name, position, inorout from attendance")
    List<Attendance> seleAllattendance();
}

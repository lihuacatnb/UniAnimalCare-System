package com.backanimal.controller;

import com.backanimal.config.Attendance;
import com.backanimal.mapper.AttendanceMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@Slf4j
public class indexController {
    @Autowired
    private AttendanceMapper attendanceMapper;

    @RequestMapping("/index")
    public String selectattendance1(Model m){
        List<Attendance> attendances = attendanceMapper.seleAllattendance();
        m.addAttribute("seleAllattendance", attendances);
        return "index";
    }
}

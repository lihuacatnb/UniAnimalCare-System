package com.backanimal.controller;

import com.backanimal.config.Area;
import com.backanimal.mapper.AreaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@Slf4j
public class areaController {

    @Autowired
    private AreaMapper areaMapper;

    @RequestMapping("/showarea")
    public String showarea1(Model m ){
        List<Area> areas = areaMapper.seleAllarea();
        m.addAttribute("seleAllarea", areas);
        return "showarea";
    }

}

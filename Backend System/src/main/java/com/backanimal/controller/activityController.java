package com.backanimal.controller;

import com.backanimal.config.Activity;
import com.backanimal.config.User;
import com.backanimal.mapper.ActivityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Slf4j
public class activityController {

    @Autowired
    private ActivityMapper activityMapper;

    @RequestMapping("/showactivity")
    public String showactivity1(Model m){
        List<Activity> activities = activityMapper.seleAllactivity();
        m.addAttribute("seleAllactivity", activities);
        return "showactivity";
    }

    @RequestMapping("/addactivity")
    public String addactivity1(){
        return "addactivity";
    }

    @RequestMapping("/addactivity1")
    public String addactivity2(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String program = request.getParameter("program");
        String manager = request.getParameter("manager");

        log.info("name:{}", name);
        log.info("program:{}", program);
        log.info("manager:{}", manager);

        Activity activity=activityMapper.selectActivity(name);
        if(activity== null){
            activityMapper.saveActivity(name,program,manager);
            return "redirect:showactivity";
        }else{
            return "加入重复数据，新增失败";
        }
    }

    @RequestMapping("/deleteactivity")
    public String deleteactivity1(){
        return "deleteactivity";
    }

    @RequestMapping("/updateactivity")
    public String updateactivity1(){
        return "updateactivity";
    }

    @RequestMapping("/delactivity")
    public String deleteactivity2(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        log.info("name:{}",name);
        activityMapper.deleteActivity(name);
        return "redirect:showactivity";
    }

    @RequestMapping("/reviseactivity1")
    public String reviseactivity11(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String program = request.getParameter("program");
        log.info("name:{}",name);
        log.info("program:{}",program);
        activityMapper.resiveActivity1(name,program);
        return "redirect:showactivity";
    }

    @RequestMapping("/reviseactivity2")
    public String reviseactivity21(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String manager= request.getParameter("manager");
        log.info("name:{}",name);
        log.info("manager:{}",manager);
        activityMapper.resiveActivity2(name,manager);
        return "redirect:showactivity";
    }

}

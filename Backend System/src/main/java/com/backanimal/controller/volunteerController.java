package com.backanimal.controller;

import com.backanimal.config.User;
import com.backanimal.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Slf4j
public class volunteerController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/showvolunteer")
    public String showvolunteer(Model m){
        List<User> volunteers = userMapper.seleAllvolunteer();
        m.addAttribute("seleAllvolunteer", volunteers);
        return "showvolunteer";
    }

    @RequestMapping("/addvolunteer")
    public String addvolunteer1(){
        return "addvolunteer";
    }

    @RequestMapping("/addvolunteer1")
    public String addvolunteer2(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        log.info("name:{}", name);
        log.info("number:{}", number);
        log.info("email:{}", email);
        log.info("password:{}", password);

        User user=userMapper.selectUserNumber(number);
        if(user== null){
            userMapper.saveUser(name,number,email,password);
            return "redirect:showvolunteer";
        }else{
            return "加入重复数据，新增失败";
        }
    }

    @RequestMapping("/deletevolunteer")
    public String deletevolunteer1(){
        return "deletevolunteer";
    }

    @RequestMapping("/delvolunteer")
    public String deletevolunteer2(HttpServletRequest request)
    {
        String email = request.getParameter("email");
        log.info("email:{}",email);
        userMapper.deleteVolunteer(email);
        return "redirect:showvolunteer";
    }

    @RequestMapping("/updatevolunteer")
    public String updateadmin1(){
        return "updatevolunteer";
    }

    @RequestMapping("/revisevolunteer1")
    public String revisevolunteer11(HttpServletRequest request)
    {
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        log.info("email:{}",email);
        log.info("number:{}",number);
        userMapper.resiveVolunteer1(email,number);
        return "redirect:showvolunteer";
    }

    @RequestMapping("/revisevolunteer2")
    public String revisevolunteer21(HttpServletRequest request)
    {
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        log.info("email:{}",email);
        log.info("name:{}",name);
        userMapper.resiveVolunteer2(email,name);
        return "redirect:showvolunteer";
    }




}

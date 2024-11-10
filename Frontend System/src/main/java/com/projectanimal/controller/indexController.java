package com.projectanimal.controller;

import com.projectanimal.config.User;
import com.projectanimal.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class indexController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/adduser")
    public String addusers(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        String password= request.getParameter("password");
        log.info("name:{}",name);
        log.info("number:{}",number);
        log.info("eamil:{}",email);
        log.info("pasword:{}",password);
        User user = userMapper.selectUserNumber(number);
        if(user== null){
            userMapper.saveUser(name,number,email,password);
            return "redirect:/more";
        }else{
            return "注意注意，不要重复注册，返回首页正确填写";
        }
    }

    @RequestMapping("/index")
    public String index1( ){
        return "index";
    }


}

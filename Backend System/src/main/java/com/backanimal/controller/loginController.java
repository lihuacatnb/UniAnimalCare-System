package com.backanimal.controller;

import com.backanimal.config.Administrator;
import com.backanimal.mapper.AdministratorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class loginController {
    @Autowired
    private AdministratorMapper administratorMapper;

    @RequestMapping("/adminlogin")
    public String adminlogin1(HttpServletRequest request)
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        log.info("email:{}", email);
        log.info("password:{}", password);

        // 添加姓名和密码验证逻辑
        if (email != null && !email.isEmpty() && password != null && !password.isEmpty()) {
            Administrator administrator=administratorMapper.loginAdministrator(email,password);
            if (administrator != null) {
                return "redirect:index";
            }
        }
        // 如果验证失败或未提供有效的姓名和密码，返回登录页
        return "login";
    }

    @RequestMapping("/")
    public String login1(){
        return "login";
    }

    @RequestMapping("/login")
    public String login2(){
        return "login";
    }


}

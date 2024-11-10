package com.backanimal.controller;

import com.backanimal.config.Administrator;
import com.backanimal.config.Animal;
import com.backanimal.mapper.AdministratorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Slf4j
public class administratorController {
    @Autowired
    AdministratorMapper administratorMapper;

    @RequestMapping("/deleteAdmin")
    public String deleteadmin (){
        return "deleteAdmin";
    }

    @RequestMapping("/deladmin")
    public String managerdatadelete1(HttpServletRequest request)
    {
        String email = request.getParameter("email");
        log.info("email:{}",email);
        administratorMapper.deleteAdministrator(email);
        return "redirect:login";
    }

    @RequestMapping("/updateAdmin")
    public String updateadmin1(){
        return "updateAdmin";
    }

    @RequestMapping("/reviseadmin")
    public String reviseadmin1(HttpServletRequest request)
    {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        log.info("email:{}",email);
        log.info("password:{}",password);
        administratorMapper.resiveAdministrator(email, password);
        return "redirect:login";
    }

    @RequestMapping("/showadmin")
    public String showadmin1(Model m ){
        List<Administrator> admins = administratorMapper.seleAlladmin();
        m.addAttribute("seleAlladmin", admins);
        return "showadmin";
    }

}

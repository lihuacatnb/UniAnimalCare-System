package com.backanimal.controller;

import com.backanimal.config.Administrator;
import com.backanimal.config.Message;
import com.backanimal.mapper.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Slf4j
public class moreController {
    @Autowired
    private MessageMapper messageMapper;

    @RequestMapping("/showmessage")
    public String showmessage1(Model m ){
        List<Message> messages = messageMapper.selectAllmessage();
        m.addAttribute("seleAllmessage", messages);
        return "showmessage";
    }

    @RequestMapping("/deletemessage")
    public String deletemessage1(){
        return "deletemessage";
    }

    @RequestMapping("/delmessage")
    public String deletemessage2(HttpServletRequest request)
    {
        String content = request.getParameter("content");
        log.info("content:{}",content);
        messageMapper.deleteMessage(content);
        return "redirect:showmessage";
    }

}

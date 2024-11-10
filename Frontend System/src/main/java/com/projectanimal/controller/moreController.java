package com.projectanimal.controller;

import com.projectanimal.config.Message;
import com.projectanimal.config.User;
import com.projectanimal.mapper.MessageMapper;
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

    @RequestMapping("/more")
    public String more(Model m){
        List<Message> messages = messageMapper.selectMore();
        m.addAttribute("selectcontont",messages);
        return "/more";
    }

    @RequestMapping("/addmessage")
    public String addmessages(HttpServletRequest request)
    {
        String content = request.getParameter("content");
        log.info("content:{}",content);
        Message message= messageMapper.selectMessageContent(content);
        if(message== null){
            messageMapper.saveMessage(content);
            return "redirect:/more";
        }else{
            return "注意注意，不要重复写留言";
        }
    }

}

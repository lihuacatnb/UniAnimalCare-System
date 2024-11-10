package com.projectanimal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@Slf4j
public class activityController {

    @RequestMapping("/activity")
    public String activity1( ){
        return "activity";
    }


}

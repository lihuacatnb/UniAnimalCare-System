package com.backanimal.controller;

import com.backanimal.config.Animal;
import com.backanimal.mapper.AnimalMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Slf4j
public class animalController {

    @Autowired
    private AnimalMapper animalMapper;

    @RequestMapping("/showanimal")
    public String showanimal1(Model m ){
        List<Animal> animals = animalMapper.seleAllanimal();
        m.addAttribute("seleAllanimal", animals);
        return "showanimal";
    }

    @RequestMapping("/addanimal")
    public String addanimal1(){
        return "addanimal";
    }

    @RequestMapping("/addanimal1")
    public String addanimal11(HttpServletRequest request){
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String area = request.getParameter("area");
        String situation = request.getParameter("situation");

        log.info("name:{}", name);
        log.info("type:{}", type);
        log.info("area:{}", area);
        log.info("situation:{}", situation);

        Animal animal=animalMapper.selectanimal(name,type);
        if(animal== null){
            animalMapper.saveAnimal(name,type,area,situation);
            return "redirect:showanimal";
        }else{
            return "加入重复数据，新增失败";
        }
    }

    @RequestMapping("/deleteanimal")
    public String deletevolunteer1(){
        return "deleteanimal";
    }

    @RequestMapping("/delanimal")
    public String deleteanimal2(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        log.info("name:{}",name);
        animalMapper.deleteAnimal(name);
        return "redirect:showanimal";
    }

    @RequestMapping("/updateanimal")
    public String updateanimal1(){
        return "updateanimal";
    }


    @RequestMapping("/reviseanimal1")
    public String reviseanimal11(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String area = request.getParameter("area");
        log.info("name:{}",name);
        log.info("area:{}",area);
        animalMapper.resiveAnimal1(name,area);
        return "redirect:showanimal";
    }

    @RequestMapping("/reviseanimal2")
    public String reviseanimal21(HttpServletRequest request)
    {
        String name = request.getParameter("name");
        String situation = request.getParameter("situation");
        log.info("name:{}",name);
        log.info("situation:{}",situation);
        animalMapper.resiveAnimal2(name,situation);
        return "redirect:showanimal";
    }

}

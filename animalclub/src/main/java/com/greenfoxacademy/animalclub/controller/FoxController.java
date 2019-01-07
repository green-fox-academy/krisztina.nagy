package com.greenfoxacademy.animalclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoxController {

    @GetMapping("/index")
    public String showMainPage(){
        return "index";
    }

}

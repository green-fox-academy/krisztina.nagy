package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class HelloWebController {

    @RequestMapping(value = "/web/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", " World");
        return "greeting";

    }
}

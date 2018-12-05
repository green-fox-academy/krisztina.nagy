package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@Controller
public class HelloWebController {


    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/web/greeting")
    public String greeting(Model model, @RequestParam(value = "name", defaultValue = "World") String name) {

        model.addAttribute("name", " "+name);
        model.addAttribute("count", counter.incrementAndGet());
        return "greeting";

    }
}

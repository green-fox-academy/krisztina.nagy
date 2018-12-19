package com.greenfox.error.controller;

import com.greenfox.error.service.UserService;
import com.greenfox.error.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aze on 25/10/17.
 */
//@RequestMapping(value = "/app", method = RequestMethod.GET)
@Controller
public class AppController {

    @Autowired
    UserService service;

    @GetMapping("/")
    public String index(@ModelAttribute("user") User user, Model model) {

        //model.addAttribute("new_user", new User());
        model.addAttribute("yolo", service.getAll());
        return "index";
    }

    @PostMapping(value = "/app")
    public String create(User user) {
        service.save(user);
        return "redirect:/";
    }
}
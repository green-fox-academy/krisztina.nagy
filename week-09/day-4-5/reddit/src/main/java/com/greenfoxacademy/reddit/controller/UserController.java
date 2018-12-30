package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    private UserService userSvc;
    private String userName;

    @Autowired
    public UserController(UserService userSvc){
        this.userSvc = userSvc;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("userName", userName);
    }
}

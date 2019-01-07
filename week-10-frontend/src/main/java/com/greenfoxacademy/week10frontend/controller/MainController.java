package com.greenfoxacademy.week10frontend.controller;

import com.greenfoxacademy.week10frontend.model.Doubler;
import com.greenfoxacademy.week10frontend.model.noParamError;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {


    @GetMapping("/")
    public String showMainPage(){
        return "index.html";
    }
    }

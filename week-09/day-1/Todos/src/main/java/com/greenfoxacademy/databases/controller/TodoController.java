package com.greenfoxacademy.databases.controller;

import com.greenfoxacademy.databases.repository.TodoRepository;
import com.greenfoxacademy.databases.repository.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {


    //TodoRepository todoRepository;

    @Autowired
    public TodoController (TodoService todoService) {

    }

    @GetMapping ("/todo")
    @ResponseBody
    public String todo () {
        return "todo";
    }

    @GetMapping ({"/", "/list"})
    @ResponseBody
    public String list() {
        return "This is my first Todo";
    }
}



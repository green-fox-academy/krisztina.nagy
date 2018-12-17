package com.greenfoxacademy.databases.controller;

import com.greenfoxacademy.databases.model.Todo;
import com.greenfoxacademy.databases.repository.TodoRepository;
import com.greenfoxacademy.databases.repository.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {


    private TodoService todoSvc;

    @Autowired
    public TodoController (TodoService todoSvc) {
        this.todoSvc = todoSvc;

    }

    @GetMapping ("/todo")
    @ResponseBody
    public String todo () {
        return "todo";
    }

    @GetMapping ({"/", "/list"})
    public String list(Model model) {
        model.addAttribute("todos", todoSvc.getAll());
        return "todolist";
    }
}



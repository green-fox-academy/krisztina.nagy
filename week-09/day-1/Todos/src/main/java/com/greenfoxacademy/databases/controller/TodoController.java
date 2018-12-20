package com.greenfoxacademy.databases.controller;

import com.greenfoxacademy.databases.model.Assignee;
import com.greenfoxacademy.databases.model.Todo;
import com.greenfoxacademy.databases.repository.AssigneeService;
import com.greenfoxacademy.databases.repository.TodoRepository;
import com.greenfoxacademy.databases.repository.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class TodoController {


    private TodoService todoSvc;
    private AssigneeService assSvc;

    @Autowired
    public TodoController (TodoService todoSvc, AssigneeService assSvc) {
        this.todoSvc = todoSvc;
        this.assSvc = assSvc;
    }

    //@GetMapping ("/todo")
    //@ResponseBody
    //public String todo () {
    //    return "todo";
    //}

    @GetMapping ({"/", "/list", "/todo"})
    public String list(Model model, @RequestParam (required=false) boolean isActive) {

        if(isActive) {
            model.addAttribute("todos", todoSvc.getAll()
                    .stream()
                    .filter(todo -> !todo.isDone())
                    .collect(Collectors.toList()));
        }
        else {
            model.addAttribute("todos", todoSvc.getAll());
        }
        return "todolist";

    }

    @GetMapping ("/todo/add")
    public String newTodo (){
        return "addtodo";
    }

    @PostMapping (value = "/todo/add",
            consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addTodo (@RequestBody MultiValueMap<String, String> formData){
        Todo newTodo = new Todo(formData.toSingleValueMap().get("new-todo"));
        this.todoSvc.addTodo(newTodo);
        return "redirect:/todo";
    }

    @GetMapping ("/{id}/delete")
    public String deleteTodo (@PathVariable long id) {
        todoSvc.deleteTodo(todoSvc.getAll().stream()
            .filter(todo -> todo.getId()==id)
            .findAny()
            .orElse(null));

    // todoSvc.deleteTodoById(id);

    return "redirect:/todo";
    }

    @GetMapping ("/{id}/edit")
    public String todoEditor (@PathVariable long id, Model model) {

        model.addAttribute("todo", todoSvc.getTodoById(id));
        model.addAttribute("assignees", assSvc.getAll());
        return "edittodo";
    }

    @PostMapping (value = "/{id}/edit")
    public String updateTodo (Assignee assignee, @ModelAttribute Todo todo, @ModelAttribute List<Assignee> assignees) {
        todo.setAssignee(assignee);
        todoSvc.addTodo(todo);
        return "redirect:/todo";
    }

    @PostMapping ("/todo/search")
    public String filterTodosByTitle (String title, Model model) {
        model.addAttribute("todos", todoSvc.searchByTitle(title));
        return "todolist";
    }


}


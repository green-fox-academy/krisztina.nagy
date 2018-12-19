package com.greenfoxacademy.databases.controller;

import com.greenfoxacademy.databases.model.Todo;
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

    @Autowired
    public TodoController (TodoService todoSvc) {
        this.todoSvc = todoSvc;

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

    @PostMapping (value = "/{id}/edit",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editTodo (@RequestBody MultiValueMap<String, String> formData, @PathVariable long id) {

        Todo todo = todoSvc.getAll().stream()
                .filter(tdo -> tdo.getId() == id)
                .findAny().get();
        todo.setTitle(formData.toSingleValueMap().get("edit-name"));

        todo.setUrgent("on".equals(formData.toSingleValueMap().get("edit-urgent")));

        todo.setDone("on".equals(formData.toSingleValueMap().get("edit-done")));

        todoSvc.addTodo(todo);
        //ezeket át kell tenni a service-be

        return "redirect:/todo";
    }

    @GetMapping ("/{id}/edit")
    public String updateTodo (@PathVariable long id, Model model) {

        model.addAttribute("todo", todoSvc.getAll().stream()
                .filter(todo -> todo.getId()==id)
                .findAny()
                .orElse(null));

        return "edittodo";
    }

    @PostMapping ("/todo/search")
    public String filterTodosByTitle (String title, Model model) {
        model.addAttribute("todos", todoSvc.searchByTitle(title));
        return "todolist";
    }


}


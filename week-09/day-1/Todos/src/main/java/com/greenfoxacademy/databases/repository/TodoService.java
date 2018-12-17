package com.greenfoxacademy.databases.repository;

import com.greenfoxacademy.databases.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    TodoRepository repository;

    @Autowired
    public TodoService (TodoRepository repository) {
        this.repository = repository;
    }

    public void addTodo(Todo todo) {
        if (todo !=null) {
            this.repository.save(todo);
        }
    }

    public List<Todo> getAll() {
        List<Todo> todos = new ArrayList<>();
        repository.findAll().forEach(todos::add);
        //repository.findAll().forEach(todo -> todos.add(todo));
        return todos;
    }

}

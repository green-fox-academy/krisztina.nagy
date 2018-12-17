package com.greenfoxacademy.databases;

import com.greenfoxacademy.databases.model.Todo;
import com.greenfoxacademy.databases.repository.TodoRepository;
import com.greenfoxacademy.databases.repository.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabasesApplication implements CommandLineRunner {

    @Autowired
    TodoService service;

    public static void main(String[] args) {
        SpringApplication.run(DatabasesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Todo newTodo = new Todo(0, "I have to learn Object Relational Mapping");
        //service.addTodo(newTodo);
    }
}



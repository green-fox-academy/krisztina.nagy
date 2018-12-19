package com.greenfoxacademy.databases.repository;

import com.greenfoxacademy.databases.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findTodosByTitleContaining(String term);

}

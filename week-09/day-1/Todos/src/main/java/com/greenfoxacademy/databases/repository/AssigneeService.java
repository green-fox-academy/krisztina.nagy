package com.greenfoxacademy.databases.repository;

import com.greenfoxacademy.databases.model.Assignee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssigneeService {

    AssigneeRepository repository;

    @Autowired
    public AssigneeService (AssigneeRepository repository) {
        this.repository = repository;
    }

    public void addAssignee(Assignee assignee) {
        if (assignee !=null) {
            this.repository.save(assignee);
        }
    }

    public List<Assignee> getAll() {
        List<Assignee> assignees = new ArrayList<>();
        repository.findAll().forEach(assignees::add);
        //repository.findAll().forEach(todo -> todos.add(todo));
        return assignees;
    }

    public void deleteAssignee (Assignee assignee) {
        this.repository.delete(assignee);
    }

    public void deleteTodoById (long id){
        this.repository.deleteById(id);
    }

    public List<Assignee> searchByTitle (String searchterm) {
        return this.repository.findAssigneeByNameContaining(searchterm);
    }

    public Assignee getAssigneeById(long id) {
        return repository.findById(id).orElse(null);
    }

}

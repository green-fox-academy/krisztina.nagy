package com.greenfoxacademy.databases.repository;

import com.greenfoxacademy.databases.model.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
    List<Assignee> findAssigneeByNameContaining(String term);
}

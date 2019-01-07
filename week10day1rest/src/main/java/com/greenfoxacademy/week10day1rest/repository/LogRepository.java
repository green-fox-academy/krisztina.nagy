package com.greenfoxacademy.week10day1rest.repository;

import com.greenfoxacademy.week10day1rest.model.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {
}

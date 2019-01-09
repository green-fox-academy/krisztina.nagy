package com.greenfoxacademy.week10frontend.Repository;

import com.greenfoxacademy.week10frontend.model.Log;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {
}

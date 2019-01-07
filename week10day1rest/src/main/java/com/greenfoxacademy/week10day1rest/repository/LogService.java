package com.greenfoxacademy.week10day1rest.repository;

import com.greenfoxacademy.week10day1rest.model.Log;

import java.util.List;

public interface LogService {

    void addLog(Log log);
    List<Log> getAllEntries();

}

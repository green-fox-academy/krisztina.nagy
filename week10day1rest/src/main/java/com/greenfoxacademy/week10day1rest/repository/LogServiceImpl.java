package com.greenfoxacademy.week10day1rest.repository;

import com.greenfoxacademy.week10day1rest.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    LogRepository repo;

    @Autowired
    public LogServiceImpl(LogRepository repo){
        this.repo = repo;
    }

    @Override
    public void addLog(Log log) {
        if (log != null){
            this.repo.save(log);
        }
    }

    @Override
    public List<Log> getAllEntries() {
        List<Log>entries = new ArrayList<>();
        repo.findAll().forEach(entries::add);
        return entries;
    }

    public int countEntries() {
        int entry_count = this.getAllEntries().size();
        return entry_count;
    }
}

package com.greenfoxacademy.orientationexample.repository;


import com.greenfoxacademy.orientationexample.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryServiceImpl implements EntryService{

    EntryRepository repo;

@Autowired
public void EntryServiceImpl(EntryRepository repo){
    this.repo = repo;
}

    @Override
    public void addEntry(Entry entry) {
        if (entry != null){
            this.repo.save(entry);
        }
    }

    @Override
    public List<Entry> getAllEntries() {
        List<Entry>entries = new ArrayList<>();
        repo.findAll().forEach(entries::add);
        return entries;
    }

    public void deleteEntryById(long id){
        this.repo.deleteById(id);
    }

    public Entry getEntryByAlias(String requestedAlias){
        return this.repo.findEntryByAlias(requestedAlias);
    }


}

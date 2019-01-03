package com.greenfoxacademy.orientationexample.repository;


import com.greenfoxacademy.orientationexample.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    @Override
    public void deleteEntryById(long id){
        this.repo.deleteById(id);
    }

    @Override
    public Entry getEntryByAlias(String requestedAlias){
        return this.repo.findEntryByAlias(requestedAlias);
    }

    @Override
    public String generateSecretCode() {
        Random r = new Random();
        return String.format("%04d", r.nextInt(10000));
    }

    @Override
    public Entry getEntryById(long id) {
        return this.repo.findEntryById(id);
    }

    @Override
    public void increaseHitCountByAlias(String alias) {
        Entry hitEntry = repo.findEntryByAlias(alias);
        hitEntry.setHitCount(hitEntry.getHitCount()+1);

        repo.save(hitEntry);
    }
}

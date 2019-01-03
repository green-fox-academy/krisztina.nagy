package com.greenfoxacademy.orientationexample.repository;

import com.greenfoxacademy.orientationexample.model.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Long> {
    Entry findEntryByAlias(String requestedAlias);
    Entry findEntryById(long id);


}

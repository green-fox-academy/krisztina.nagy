package com.greenfoxacademy.orientationexample.repository;

import com.greenfoxacademy.orientationexample.model.Entry;

import java.util.ArrayList;
import java.util.List;

public interface EntryService {

    void addEntry(Entry entry);

    List<Entry> getAllEntries();

    void deleteEntryById(long id);

    Entry getEntryByAlias(String requestedAlias);

    String generateSecretCode();

    Entry getEntryById(long id);

    void increaseHitCountByAlias(String alias);
}

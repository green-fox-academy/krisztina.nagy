package com.greenfoxacademy.orientationexample.repository;

import com.greenfoxacademy.orientationexample.model.Entry;

import java.util.ArrayList;
import java.util.List;

public interface EntryService {

    void addEntry(Entry entry);

    List<Entry> getAllEntries();
}

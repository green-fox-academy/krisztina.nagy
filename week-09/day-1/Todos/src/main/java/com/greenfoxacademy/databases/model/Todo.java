package com.greenfoxacademy.databases.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    long id;

    private String title;
    private boolean urgent;
    private boolean done;

    public Todo () {

    }

    public Todo(long id, String title) {

        this.id = id;
        this.title = title;
        this.urgent = false;
        this.done = false;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public boolean isDone() {
        return done;
    }


}

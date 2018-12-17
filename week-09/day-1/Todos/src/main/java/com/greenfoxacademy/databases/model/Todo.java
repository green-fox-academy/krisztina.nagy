package com.greenfoxacademy.databases.model;

public class Todo {

    long id;
    String title;
    boolean urgent;
    boolean done;

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

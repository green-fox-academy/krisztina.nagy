package com.greenfoxacademy.springstart;

public class Greeting {
    long id;
    String Content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Greeting(long id, String content) {
        this.id = id;
        Content = content;
    }





}

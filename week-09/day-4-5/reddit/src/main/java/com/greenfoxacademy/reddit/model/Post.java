package com.greenfoxacademy.reddit.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;



    private String title;
    private String url;


    private long rating;

    public Post() {

    }

    public Post(String title, String url) {
        this.title = title;
        this.url = url;
        this.rating = 0;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public long getRating() {
        return rating;
    }
}

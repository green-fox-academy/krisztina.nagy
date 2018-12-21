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

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }
}

package com.greenfoxacademy.orientationexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Entry {

    @Id
    @GeneratedValue
    private long id;
    private String url;
    private String alias;
    private long hitCount;

    public Entry() {
    }

    public Entry(String url, String alias, long hitCount) {
        this.url = url;
        this.alias = alias;
        this.hitCount = hitCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public long getHitCount() {
        return hitCount;
    }

    public void setHitCount(long hitCount) {
        this.hitCount = hitCount;
    }
}

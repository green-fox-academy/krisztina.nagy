package com.greenfoxacademy.orientationexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonIgnoreProperties("secretCode")
@Entity
public class Entry {

    @Id
    @GeneratedValue
    private long id;
    private String url;
    private String alias;
    private long hitCount;


    private String secretCode;

    public Entry() {
    }

    public Entry(String url, String alias, long hitCount) {
        this.url = url;
        this.alias = alias;
        this.hitCount = 0;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
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

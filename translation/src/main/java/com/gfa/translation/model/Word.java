package com.gfa.translation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue
    private long id;

    private String hungarian;
    private String czech;
    private long hitCount;

    public Word(String hungarian, String czech) {
        this.hungarian = hungarian;
        this.czech = czech;
        this.hitCount = 0;
    }

    public Word() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHungarian() {
        return hungarian;
    }

    public void setHungarian(String hungarian) {
        this.hungarian = hungarian;
    }

    public String getCzech() {
        return czech;
    }

    public void setCzech(String czech) {
        this.czech = czech;
    }

    public long getHitCount() {
        return hitCount;
    }

    public void setHitCount(long hitCount) {
        this.hitCount = hitCount;
    }
}

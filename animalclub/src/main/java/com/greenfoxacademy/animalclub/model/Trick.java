package com.greenfoxacademy.animalclub.model;

import javax.persistence.*;

@Entity
public class Trick {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String imgPath;

    public Trick(){

    }

    public Trick(String name, String imgPath) {
        this.name = name;
        this.imgPath = imgPath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}

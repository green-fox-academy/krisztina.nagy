package com.greenfoxacademy.foxclub.model;

import java.util.ArrayList;
import java.util.List;

public class Aye {

    String name;
    String imgPath;
    List<String>tricks = new ArrayList<>();

    public enum Food{BASIC, DESSERT, SUPERFOOD, SCARCE};
    public enum Drink{BASIC, LUXURY, SUPERDRINK, BADDAYS};

    public String getName() {
        return name;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public Aye(String name, String imgPath) {
        this.name = name;
        this.imgPath = imgPath;
    }




}

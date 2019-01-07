package com.greenfoxacademy.animalclub.model;

import javax.persistence.*;

@Entity
public class Consumable {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private boolean isFood;

    public Consumable(){

    }

    public Consumable(String name, boolean isFood) {
        this.name = name;
        this.isFood = isFood;
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

    public boolean isFood() {
        return isFood;
    }

    public void setIsFood(boolean isFood) {
        this.isFood = isFood;
    }
}

package com.greenfoxacademy.animalclub.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Fox {

    @Id
    @GeneratedValue
    private long id;

    private String foxName;

    private Trick trick;

    private Consumable food;

    private Consumable drink;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column (name = "date_created")
    private Date dateCreated;

    public Fox(){

    }

    public Fox(String foxName) {
        this.foxName = foxName;
        this.dateCreated = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoxName() {
        return foxName;
    }

    public void setFoxName(String foxName) {
        this.foxName = foxName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Trick getTrick() {
        return trick;
    }

    public void setTrick(Trick trick) {
        this.trick = trick;
    }

    public Consumable getFood() {
        return food;
    }

    public void setFood(Consumable food) {
        this.food = food;
    }

    public Consumable getDrink() {
        return drink;
    }

    public void setDrink(Consumable drink) {
        this.drink = drink;
    }
}

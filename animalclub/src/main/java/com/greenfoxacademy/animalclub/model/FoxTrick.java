package com.greenfoxacademy.animalclub.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fox_trick")
public class FoxTrick {

    @Id
    @ManyToOne
    @JoinColumn(name = "fox-id")
    private Fox fox;

    @Id
    @ManyToOne
    @JoinColumn(name = "trick-id")
    private Trick trick;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column (name = "date_learned")
    private Date dateLearned;

    public FoxTrick(){

    }

    public FoxTrick(Fox fox, Trick trick) {
        this.fox = fox;
        this.trick = trick;
        this.dateLearned = new Date();
    }

    public Fox getFox() {
        return fox;
    }

    public void setFox(Fox fox) {
        this.fox = fox;
    }

    public Trick getTrick() {
        return trick;
    }

    public void setTrick(Trick trick) {
        this.trick = trick;
    }

    public Date getDateLearned() {
        return dateLearned;
    }

    public void setDateLearned(Date dateLearned) {
        this.dateLearned = dateLearned;
    }
}

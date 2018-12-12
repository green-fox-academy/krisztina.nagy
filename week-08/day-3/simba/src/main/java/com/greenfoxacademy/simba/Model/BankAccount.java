package com.greenfoxacademy.simba.Model;

import java.util.Random;

public class BankAccount {
    String name;
    Integer balance;
    String animalType;
    String currency;
    boolean isKing;
    String rank;
    boolean isGoodGuy;
    Random r = new Random();

    protected String isKing() {
        this.isKing = r.nextBoolean();

        if (isKing){
            return "King!";
        }
        else{
            return "Subject...";
        }
    }

    public void getCash () {
        if (this.isKing){
                balance+=100;
            }
        else{
                balance+=10;
            }

    }

    public BankAccount(String name, Integer balance, String animalType, String currency) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.currency = currency;
        this.rank = this.isKing();
        this.isGoodGuy= r.nextBoolean();
    }

    public boolean isGoodGuy() {
        return isGoodGuy;
    }
    public boolean getKing() {
        return isKing;
    }

    public String getRank() {
        return rank;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }


}

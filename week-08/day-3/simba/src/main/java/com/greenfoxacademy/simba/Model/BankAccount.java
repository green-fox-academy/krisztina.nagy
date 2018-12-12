package com.greenfoxacademy.simba.Model;

import java.util.Random;

public class BankAccount {
    String name;
    Integer balance;
    String animalType;
    String currency;
    boolean isKing;
    String rank;

    protected String isKing() {
        Random r = new Random();
        this.isKing = r.nextBoolean();

        if (isKing){
            return "King!";
        }
        else{
            return "Subject...";
        }
    }
    public BankAccount(String name, Integer balance, String animalType, String currency) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.currency = currency;
        this.rank = this.isKing();
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

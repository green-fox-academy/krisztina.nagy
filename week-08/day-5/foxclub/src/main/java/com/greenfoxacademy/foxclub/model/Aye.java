package com.greenfoxacademy.foxclub.model;

import java.util.ArrayList;
import java.util.List;

public class Aye {

    String name;
    String imgPath;
    Food food;
    Drink drink;
    List<String>tricks = new ArrayList<>();

    public enum Food {
        BASIC ("grubs"),
        DESSERT ("chocolate cake"),
        SUPERFOOD ("spinach"),
        SCARCE ("twigs");

        private final String foodName;

        Food (String food_name) {
            this.foodName = food_name;
        }

        public String toString() {
            return this.foodName;
        }

        public static Food fromString (String foodName) {
            for (Food food : Food.values()) {
                if (food.toString().equals(foodName)) {
                    return food;
                }
            }
            return null;
        }

    }

    public enum Drink {
        BASIC ("strawberry smoothie"),
        DESSERT ("champagne"),
        SUPERDRINK ("whisky"),
        SCARCE ("water");

        private final String drink_name;

        Drink (String drink_name) {
            this.drink_name =drink_name;
        }

        public String toString() {
            return this.drink_name;
        }
        public static Drink fromString (String drinkName) {
            for (Drink drink : Drink.values()) {
                if (drink.toString().equals(drinkName)) {
                    return drink;
                }
            }
            return null;
        }

    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

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

    public Aye(String name) {
        this.name = name;
        this.imgPath = "http://drive.google.com/uc?export=view&id=1Mue8_sGbSyQ9VH-gmv5eb_H6wnGf_Rd6";
        this.food = Food.BASIC;
        this.drink = Drink.BASIC;
    }




}

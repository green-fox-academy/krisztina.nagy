package com.greenfoxacademy.animalclub.repository;

import com.greenfoxacademy.animalclub.model.Consumable;
import com.greenfoxacademy.animalclub.model.Fox;
import com.greenfoxacademy.animalclub.model.FoxTrick;
import com.greenfoxacademy.animalclub.model.Trick;

import java.util.List;

public interface FoxService {

    void addFox(Fox fox);

    List<Fox> getAllFoxes();

    Fox getFoxById(long id);

    void learnTrick(Fox fox, Trick trick);

    void changeTrick(Fox fox, Trick trick);

    void changeFood(Fox fox, Consumable food);

    void changeDrink(Fox fox, Consumable drink);

    List<FoxTrick> getAllLearnedTricks(Fox fox);
}

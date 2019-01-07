package com.greenfoxacademy.animalclub.repository;

import com.greenfoxacademy.animalclub.model.Consumable;
import com.greenfoxacademy.animalclub.model.Fox;
import com.greenfoxacademy.animalclub.model.FoxTrick;
import com.greenfoxacademy.animalclub.model.Trick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoxServiceImpl implements FoxService {

FoxRepository foxRepo;
FoxTrickRepository foxTrickRepo;


@Autowired
public FoxServiceImpl(FoxRepository foxRepo, FoxTrickRepository foxTrickRepo){
    this.foxRepo = foxRepo;
    this.foxTrickRepo = foxTrickRepo;
}

    @Override
    public Fox getFoxById(long id) {
        return foxRepo.findFoxById(id);
    }

    @Override
    public List<Fox> getAllFoxes() {
    List<Fox> foxes = new ArrayList<>();
    foxRepo.findAll().forEach(foxes::add);
    return foxes;
    }

    @Override
    public void addFox(Fox fox) {
        if(fox != null){
            foxRepo.save(fox);
        }
    }

    @Override
    public void changeDrink(Fox fox, Consumable drink) {
        fox.setDrink(drink);
    }

    @Override
    public void changeFood(Fox fox, Consumable food) {
        fox.setFood(food);
    }

    @Override
    public void changeTrick(Fox fox, Trick trick) {
        fox.setTrick(trick);
    }

    @Override
    public void learnTrick(Fox fox, Trick trick) {
        if (fox != null && trick != null) {
            foxTrickRepo.save(new FoxTrick(fox, trick));
        }
    }

    @Override
    public List<FoxTrick> getAllLearnedTricks(Fox fox) {
        List<FoxTrick> foxTricks = new ArrayList<>();
        foxTrickRepo.findAll().forEach(foxTricks::add);
        return foxTricks;
    }
}

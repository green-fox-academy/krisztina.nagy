package com.greenfoxacademy.foxclub.model;

import com.greenfoxacademy.foxclub.repository.ZooAyes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Zoo {

    public Zoo() {

    }
    public ArrayList<Aye> getAyes(){
        return ZooAyes.getInstance().getZooAyes();
    }

    public Aye getAye (String name){
        for (Aye a : ZooAyes.getInstance().getZooAyes()) {
            if (a.getName().equals(name)){
                return a;
            }
        }
        return null;
    }

    public void addAye(Aye newa){
        boolean isInZoo=false;
        for (Aye a:ZooAyes.getInstance().getZooAyes()) {
            if (a.getName().equals(newa.getName())){
                isInZoo = true;
                //itt el kell intézni, mi legyen, ha mér van ilyen állat.
            }
            if (!isInZoo){
                ZooAyes.getInstance().addAye(newa);
            }
        }
}
}

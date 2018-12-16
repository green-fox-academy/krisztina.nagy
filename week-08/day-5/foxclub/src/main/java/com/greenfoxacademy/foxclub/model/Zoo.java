package com.greenfoxacademy.foxclub.model;

import com.greenfoxacademy.foxclub.exceptions.NameAlreadyExistsException;
import com.greenfoxacademy.foxclub.repository.ZooAyes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Zoo {

    public Zoo() {

    }

    public ArrayList<Aye> getAyes() {
        return ZooAyes.getInstance().getZooAyes();
    }

    public Aye getAye(String name) {
        for (Aye a : ZooAyes.getInstance().getZooAyes()) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

    public void addAye(Aye newa) throws NameAlreadyExistsException {

        for (Aye a : ZooAyes.getInstance().getZooAyes()) {
            if (a.getName().equals(newa.getName())) {
                throw new NameAlreadyExistsException(newa.getName());
            }
        }
        ZooAyes.getInstance().addAye(newa);
    }
}

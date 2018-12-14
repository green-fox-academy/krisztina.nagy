package com.greenfoxacademy.foxclub.repository;

import com.greenfoxacademy.foxclub.model.Aye;

import java.util.ArrayList;

public class ZooAyes {

    ArrayList<Aye> zooAyes;

    public ArrayList<Aye> getZooAyes() {
        return zooAyes;
    }
    public void addAye(Aye a) {
        zooAyes.add(a);
    }

    private ZooAyes(){
        this.zooAyes =new ArrayList();
    }

    private static ZooAyes instance;

    public static ZooAyes getInstance () {
        if(ZooAyes.instance == null) {
            ZooAyes.instance = new ZooAyes();
        }
        return ZooAyes.instance;
    }


}

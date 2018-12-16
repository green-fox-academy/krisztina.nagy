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
        //this.zooAyes.add(new Aye("AyeCaptain", "http://drive.google.com/uc?export=view&id=1Mue8_sGbSyQ9VH-gmv5eb_H6wnGf_Rd6"));

    }

    private static ZooAyes instance;

    public static ZooAyes getInstance () {
        if(ZooAyes.instance == null) {
            ZooAyes.instance = new ZooAyes();
        }
        return ZooAyes.instance;
    }


}

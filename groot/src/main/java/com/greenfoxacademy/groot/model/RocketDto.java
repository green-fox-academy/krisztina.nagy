package com.greenfoxacademy.groot.model;

public class RocketDto {

    public Integer caliber25;
    public Integer caliber30;
    public Integer caliber50;
    public String shipStatus;
    public boolean ready;

    public RocketDto(Rocket rc) {
        this.caliber25 = rc.caliber25;
        this.caliber30 = rc.caliber30;
        this.caliber50 = rc.caliber50;
        this.shipStatus = rc.shipStatus;
        this.ready = rc.ready;

    }




}

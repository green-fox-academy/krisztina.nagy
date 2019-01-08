package com.greenfoxacademy.groot.model;

public class FillThatRocketDto {

    public String received;
    public Integer amount;
    public String shipstatus;
    public boolean ready;

    public FillThatRocketDto(Rocket rc, RocketCargoFill rcf) {
        rc.fill(rcf);
        this.received = rcf.received;
        this.amount = rcf.amount;
        this.shipstatus = rc.shipStatus;
        this.ready = rc.ready;
    }
}

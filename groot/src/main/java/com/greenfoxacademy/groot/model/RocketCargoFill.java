package com.greenfoxacademy.groot.model;

import javax.validation.constraints.Max;

public class RocketCargoFill {

    public String received;
    @Max(12500)
    public Integer amount;

    public RocketCargoFill() {
    }

    public RocketCargoFill(String received, Integer amount) {

        this.received = received;
        this.amount = amount;
    }
}

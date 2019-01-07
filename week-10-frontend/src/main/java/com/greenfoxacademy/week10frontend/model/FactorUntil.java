package com.greenfoxacademy.week10frontend.model;

public class FactorUntil {

    private Integer result=1;

    public FactorUntil(Integer until){
        for (int i=0; i<until; i++){
         result*=(i+1);
        }
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}

package com.greenfoxacademy.week10frontend.model;

public class SumUntil {

    private Integer result=0;

    public SumUntil(Integer until){
        for (int i=0; i<until; i++){
            result+=(i+1);
        }
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}

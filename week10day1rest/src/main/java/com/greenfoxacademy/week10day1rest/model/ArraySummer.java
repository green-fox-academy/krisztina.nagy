package com.greenfoxacademy.week10day1rest.model;

public class ArraySummer {

    private Integer result=0;

    public ArraySummer(int[] numbers){
        for (int i=0; i<numbers.length; i++){
            result+=(numbers[i]);
        }
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}

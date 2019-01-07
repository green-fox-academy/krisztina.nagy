package com.greenfoxacademy.week10day1rest.model;

public class ArrayDoubler {

    private int[] result;

    public ArrayDoubler(int[] numbers){

        result = new int[numbers.length];
        for (int i=0; i<numbers.length; i++){
            result[i] = numbers[i]*2;
        }

    }

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }
}

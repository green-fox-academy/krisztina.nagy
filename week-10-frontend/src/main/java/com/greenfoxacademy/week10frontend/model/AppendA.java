package com.greenfoxacademy.week10frontend.model;

public class AppendA {

    private String appended;

    public AppendA(String input){
        this.appended = input + 'a';
    }

    public String getAppended() {
        return appended;
    }

    public void setAppended(String appended) {
        this.appended = appended;
    }
}

package com.greenfoxacademy.week10day1rest.model;

public class NoParamError {
    
    private String error;

    public NoParamError() {
        error = "Please provide an input!";
    }

    public NoParamError(String input){
        error = String.format("Please provide a %s!", input);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

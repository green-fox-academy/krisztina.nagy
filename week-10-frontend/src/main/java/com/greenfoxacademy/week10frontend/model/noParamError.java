package com.greenfoxacademy.week10frontend.model;

public class noParamError {
    
    private String error;

    public noParamError() {
        error = "Please provide an input!";
    }

    public noParamError(String input){
        error = String.format("Please provide a %s!", input);
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

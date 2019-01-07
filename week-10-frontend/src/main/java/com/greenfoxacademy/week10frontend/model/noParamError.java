package com.greenfoxacademy.week10frontend.model;

public class noParamError {
    
    private String error;

    public noParamError() {
        error = "Please provide an input!";
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

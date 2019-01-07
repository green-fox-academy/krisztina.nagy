package com.greenfoxacademy.week10frontend.model;

public class ArrayError {
    private String error;

    public ArrayError(String msg) {
        error = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

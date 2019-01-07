package com.greenfoxacademy.week10frontend.model;

public class Doubler {

    private int received;
    private int result;

    public Doubler() {

    }

    public Doubler(int received) {
        this.received = received;
        this.result = received*2;
    }

    public int getReceived() {
        return received;
    }

    public void setReceived(int received) {
        this.received = received;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}

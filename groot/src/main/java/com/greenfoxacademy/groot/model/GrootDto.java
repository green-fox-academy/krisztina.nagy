package com.greenfoxacademy.groot.model;

public class GrootDto {

    public String received;
    public String translated;

    public GrootDto() {
    }

    public GrootDto(String received) {
        this.received = received;
        this.translated = "I am Groot!";
    }
}

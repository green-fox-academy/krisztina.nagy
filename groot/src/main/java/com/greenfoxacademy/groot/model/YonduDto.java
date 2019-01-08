package com.greenfoxacademy.groot.model;

public class YonduDto {
    public float distance;
    public float time;
    public float speed;

    public YonduDto() {
    }

    public YonduDto(float distance, float time) {
        this.distance = distance;
        this.time = time;
        this.speed = distance/time;
    }
}

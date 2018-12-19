package com.greenfox.error.model;

import org.springframework.context.annotation.Bean;

/**
 * Created by aze on 25/10/17.
 */
public class User {
    public User(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    private String firstName;
    private String lastName;
}

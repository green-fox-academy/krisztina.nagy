package com.greenfoxacademy.reddit;

import com.greenfoxacademy.reddit.Service.UserService;
import com.greenfoxacademy.reddit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedditApplication{

    @Autowired
    UserService userSvc;

    public static void main(String[] args) {
        SpringApplication.run(RedditApplication.class, args);
    }
}


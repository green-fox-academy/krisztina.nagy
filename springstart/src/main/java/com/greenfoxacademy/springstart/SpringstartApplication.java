package com.greenfoxacademy.springstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class SpringstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringstartApplication.class, args);

        hello();


    }

    @RequestMapping(value="/hello")
    @ResponseBody
    private static String hello() {
        String s = "HElloWorld!";
        return s;
    }
}

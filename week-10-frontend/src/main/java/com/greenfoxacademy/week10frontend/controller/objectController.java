package com.greenfoxacademy.week10frontend.controller;

import com.greenfoxacademy.week10frontend.model.Doubler;
import com.greenfoxacademy.week10frontend.model.noParamError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class objectController {

    @GetMapping("/doubling")
    public Object doubleTheInput(@RequestParam(required=false) Integer input){
        if (input != null) {
            return new Doubler(input);
        }
        else {
            return new noParamError();
        }
    }
}

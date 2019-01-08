package com.greenfoxacademy.groot.Controller;

import com.greenfoxacademy.groot.model.GrootDto;
import com.greenfoxacademy.groot.model.GrootError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuardianController {

    public GuardianController(){}

    @GetMapping("/groot")
    public ResponseEntity<Object> getGroot(@RequestParam(required = false) String message){
        if (message!=null) {
            return new ResponseEntity(new GrootDto(message), HttpStatus.OK);
        }
        else {
            return new ResponseEntity(new GrootError("I am Groot!"), HttpStatus.BAD_REQUEST);
        }
    }
}

package com.greenfoxacademy.groot.Controller;

import com.greenfoxacademy.groot.model.*;
import com.greenfoxacademy.groot.model.Error;
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
            return new ResponseEntity(new Error("I am Groot!"), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/yondu")
    public ResponseEntity<YonduDto> getYondu(@RequestParam(required = false) Float distance,
                                             @RequestParam(required = false) Float time){
        if(distance==null || time == null){
            return new ResponseEntity(new Error("Please provide the distance and the time!"), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(new YonduDto(distance, time), HttpStatus.OK);
        }
    }
    @GetMapping("/rocket")
    public ResponseEntity<RocketDto> getCargo(){
        return new ResponseEntity(new Rocket(), HttpStatus.OK);
    }

    @GetMapping("/rocket/fill")
    public ResponseEntity<Object> fillCargo(@RequestParam String caliber, @RequestParam Integer amount){
        return new ResponseEntity(new FillThatRocketDto(new Rocket(), new RocketCargoFill(caliber, amount)), HttpStatus.OK);

    }

}

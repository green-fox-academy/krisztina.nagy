package com.greenfoxacademy.spellcheckerdependency.Service;

import com.greenfoxacademy.spellcheckerdependency.controller.MyColour;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class YellowColour implements MyColour {
    public void printColour(String message, Printer printer){
        printer.log(LocalDateTime.now() + " " +message + " It is yellow in color...");
    }
}

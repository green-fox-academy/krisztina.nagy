package com.greenfoxacademy.spellcheckerdependency.Service;

import com.greenfoxacademy.spellcheckerdependency.controller.MyColour;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//@Service
public class GreenColour implements MyColour {
    public void printColour(String message, Printer printer){
        printer.log(LocalDateTime.now() + " " +message + " It is green in color...");
    }
}

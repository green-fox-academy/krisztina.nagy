package com.greenfoxacademy.spellcheckerdependency.Service;

import com.greenfoxacademy.spellcheckerdependency.controller.MyColour;

import java.time.LocalDateTime;

public class BlueColour implements MyColour {
    public void printColour(String message, Printer printer){
        printer.log(LocalDateTime.now() + " " +message + " It is blue in color...");
    }
}

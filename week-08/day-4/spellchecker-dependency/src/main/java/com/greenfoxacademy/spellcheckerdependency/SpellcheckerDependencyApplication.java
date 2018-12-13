package com.greenfoxacademy.spellcheckerdependency;

import com.greenfoxacademy.spellcheckerdependency.Service.BlueColour;
import com.greenfoxacademy.spellcheckerdependency.Service.Printer;
import com.greenfoxacademy.spellcheckerdependency.controller.MyColour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpellcheckerDependencyApplication implements CommandLineRunner {


    @Autowired
    Printer printer;

    @Autowired
    MyColour myColour;

    public static void main(String[] args) {

        SpringApplication.run(SpellcheckerDependencyApplication.class, args);


    }

    //@Override
    //public void run(String[] args) throws Exception {
    //    printer.log("ez itt az üzi");
    //}

    @Override
    public void run(String... args) throws Exception {
        myColour.printColour("Ez itten az üzi.", printer);
    }


}


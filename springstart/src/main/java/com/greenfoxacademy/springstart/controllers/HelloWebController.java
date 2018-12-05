package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;


@Controller
public class HelloWebController {


    private final AtomicLong counter = new AtomicLong();
    String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
            "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
            "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
            "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

    @RequestMapping(value = "/web/greeting")
    public String greeting(Model model, @RequestParam(value = "name", defaultValue = "World") String name) {

        Random rand = new Random();

        int helloIndex = rand.nextInt(hellos.length);
        int size = rand.nextInt(50)+8;

        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);

        Color randColor = new Color(r, g, b);

        model.addAttribute("hello", hellos[helloIndex]);
        model.addAttribute("name", " "+name);
        model.addAttribute("count", counter.incrementAndGet());
        model.addAttribute("color", "rgb(" + r +", " + g +", " + b + ")");
        model.addAttribute("size", size);



        return "greeting";

    }
}

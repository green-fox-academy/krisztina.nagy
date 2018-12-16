package com.greenfoxacademy.foxclub.controller;

import com.greenfoxacademy.foxclub.exceptions.NameAlreadyExistsException;
import com.greenfoxacademy.foxclub.model.Aye;
import com.greenfoxacademy.foxclub.model.Zoo;
import com.greenfoxacademy.foxclub.repository.ZooAyes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private Zoo zoo;

    @Autowired
    public MainController(Zoo zoo) {
        this.zoo = zoo;
        try {
            zoo.addAye(new Aye("AyeCaptain", "http://drive.google.com/uc?export=view&id=1Mue8_sGbSyQ9VH-gmv5eb_H6wnGf_Rd6"));
        } catch (NameAlreadyExistsException e) {
            e.printStackTrace();
        }

        zoo.getAye("AyeCaptain").getTricks().add("Stare");


    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping(
            value = "/login",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createPet(@RequestBody MultiValueMap<String, String> formData) {

        Aye newAye = new Aye(
                formData.toSingleValueMap().get("name"),
                formData.toSingleValueMap().get("img-url")
        );
        try {
            zoo.addAye(newAye);
        } catch (NameAlreadyExistsException e) {
            e.printStackTrace();
            return "redirect:/login";
        }
        return "redirect:/?name=" + newAye.getName();
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String name) {
        System.out.println(this.zoo.getAyes().size());
        System.out.println(this.zoo.getAye(name));
        if (name != null && zoo.getAye(name) != null) {
            model.addAttribute("aye", zoo.getAye(name));
            return "index";
        }
        else return "redirect:/login";
    }

    @GetMapping ("/nutritionStore")
    public String nutritionStore (Model model, @RequestParam String name) {
        if (name != null && zoo.getAye(name) != null) {
            model.addAttribute("aye", zoo.getAye(name));
            return "nutritionStore";
        }
        else return "redirect:/login";
    }

    @PostMapping (value = "/nutritionStore",
                consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String changeNutrition (@RequestBody MultiValueMap<String, String> formData) {

        Aye particularAye = zoo.getAye(formData.toSingleValueMap().get("pet-name"));

        particularAye.setFood(Aye.Food.fromString(formData.toSingleValueMap().get("food")));
        particularAye.setDrink(Aye.Drink.fromString(formData.toSingleValueMap().get("drink")));
        return "redirect:/?name=" + particularAye.getName();
    }

}

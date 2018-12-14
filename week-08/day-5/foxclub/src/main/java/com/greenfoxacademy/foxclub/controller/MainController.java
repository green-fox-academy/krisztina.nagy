package com.greenfoxacademy.foxclub.controller;

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
    String actualPet;

    @Autowired
    public MainController(Zoo zoo) {
        this.zoo = zoo;
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
                formData.toSingleValueMap().get("url")
        );
        zoo.addAye(newAye);
        return "redirect:/?name=" + newAye.getName();
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(required = false) String name) {
        System.out.println(this.zoo.getAyes().size());
        if (name != null && zoo.getAye(name) != null) {
            model.addAttribute("animals", zoo);
            return "index";
        } else return "redirect:/login";
    }

}

package com.greenfoxacademy.spellcheckerdependency.controller;

import com.greenfoxacademy.spellcheckerdependency.Service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrintController {

    @Autowired UtilityService util;

    public PrintController () {

    }

    @GetMapping ("/useful")
    public String useful () {

        return "index";
    }

    @GetMapping ("/useful/colored")
    public String colored (Model model) {
        model.addAttribute("color", util.randomColor());
        return "colored";              //how can i display error message in case there is an error..?
    } //why can't i use this model to change the background on /useful or on index.html??

    //@GetMapping ("/error")
    //public String error (Model model) {
    //model.addAttribute("error", )
    //}

    @GetMapping("/useful/email")
    public String validateEmail(Model model, @RequestParam String email) {

        model.addAttribute("email", email);
        model.addAttribute("valid", util.validateEmail(email));
        //model.addAttribute("products", products
        //        .stream()
        //        .filter(product -> product.qty > qty)
        //        .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/useful/caesar-encode")
    public String cEncode (Model model, @RequestParam String text, @RequestParam int number){
        model.addAttribute("encoded", util.caesar(text, number));
        return "index";
    }

    @GetMapping("/useful/caesar-decode")
    public String cDecode (Model model, @RequestParam String text, @RequestParam int number){
        model.addAttribute("decoded", util.caesar(text, -number));
        return "index";
    }
}

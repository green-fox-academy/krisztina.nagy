package com.gfa.translation.controller;


import com.gfa.translation.model.Word;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String showMainPage(Model model, @ModelAttribute(value="inputWordList") List<Word> inputWords){
        boolean isRedirected = false;
        model.addAttribute("translation", new TranslationDto());
        model.addAttribute("redirected", isRedirected);
        return "index";
    }

    @PostMapping("/")
    public String translateWords(Model model, @ModelAttribute(value="translation") TranslationDto trans, @ModelAttribute(value="redirected") boolean isRedirected) {

        List<Word> inputWordList = new ArrayList<>();

        model.addAttribute("inputWordList", new ArrayList<Word>());

        isRedirected=true;
        
        return "redirect:/";

    }
}

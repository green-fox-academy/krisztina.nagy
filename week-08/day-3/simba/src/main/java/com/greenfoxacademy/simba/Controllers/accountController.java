package com.greenfoxacademy.simba.Controllers;

import com.greenfoxacademy.simba.Model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class accountController {

    private List<BankAccount> accounts =new ArrayList<>();
    // BankAccount simbaAcc = new BankAccount("Simba", 2000, "Lion");

    public accountController() {
        accounts.add(new BankAccount("Simba", 2000, "Lion", "Zebra"));
        accounts.add(new BankAccount("Buksi", 5000, "Python", "Gold"));
        accounts.add(new BankAccount("Korci", 8000, "Bear", "IQ"));
        accounts.add(new BankAccount("Zsivány", 2000, "Mudi", "Nyaff"));
        accounts.add(new BankAccount("Souris", 1500, "Honeybadger", "Mlem"));
        accounts.add(new BankAccount("Chinook", 3500, "Dragon", "Nyú"));
    }

    @GetMapping(path = "/show")
    public String showAcc(Model model) {
        model.addAttribute("accounts", accounts);
        return "show";
    }

    @GetMapping (path = "/endlessfun")
    public String textFun (Model model) {
        model.addAttribute("text", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        return "endlessfun";
    }

    @GetMapping (path= "/show-table")
    public String showTable (Model model) {
        model.addAttribute("accounts", accounts);
        return "show-table";
    }

    @PostMapping ("/get-cash")
    public String deusExCash (String id) {
        accounts.get(Integer.parseInt(id)).getCash();
      return "redirect:/show-table";
    }
}

package com.greenfoxacademy.simba.Controllers;

import com.greenfoxacademy.simba.Model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class accountController {

    private List<BankAccount> accounts =new ArrayList<>();
    // BankAccount simbaAcc = new BankAccount("Simba", 2000, "Lion");

    public accountController() {
        accounts.add(new BankAccount("Simba", 2000, "Lion", "Zebra"));
    }

    @GetMapping(path = "/show")
    public String showAcc(Model model) {
        model.addAttribute("accounts", accounts);
        return "show";
    }

    @GetMapping (path = "/endlessfun")
    public String textFun (Model model) {
        return "endlessfun";
    }
}

package com.greenfoxacademy.orientationexample.controller;

import com.greenfoxacademy.orientationexample.model.DeleteInput;
import com.greenfoxacademy.orientationexample.model.Entry;
import com.greenfoxacademy.orientationexample.repository.EntryService;
import com.greenfoxacademy.orientationexample.repository.EntryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EntryController {
    private EntryService entrySvc;

    @Autowired
    public EntryController(EntryService entrySvc){
        this.entrySvc = entrySvc;
    }

    /*@ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "0");
    }*/

    @GetMapping("/")
    public String showMainPage(Model model, HttpServletRequest request){
        model.addAttribute("entry", new Entry());
        Object msg = request.getSession().getAttribute("msg");
        model.addAttribute("message", msg);

        if (msg != null && (int) msg == 1) {
            model.addAttribute("lastEntry", entrySvc.getEntryById((long)request.getSession().getAttribute("id")));
        }

        return "index";
    }

    @PostMapping("/save-link")
    public String saveLink (@ModelAttribute Entry entry, HttpServletRequest request){

        if (entrySvc.getEntryByAlias(entry.getAlias()) == null){
            entry.setSecretCode(entrySvc.generateSecretCode());
            entrySvc.addEntry(entry);
            request.getSession().setAttribute("msg", 1);
            request.getSession().setAttribute("id", entry.getId());
            return "redirect:/";
        }
        else {
            request.getSession().setAttribute("msg", 2);
            return "redirect:/";
        }

    }

    @GetMapping("/a/{alias}")
    public String hitAlias(@PathVariable String alias, HttpServletResponse res) throws IOException {
        if (entrySvc.getEntryByAlias(alias) != null) {
            entrySvc.increaseHitCountByAlias(alias);
            return "redirect:" + entrySvc.getEntryByAlias(alias).getUrl();
        }
        else {
            res.sendError(404);
            return null;
        }


    }

    @GetMapping("/api/links")
    public List<Entry> showEntries(){
        List<Entry> entries = new ArrayList<>();
        entrySvc.getAllEntries().forEach(entries::add);
        return entries;

    }

    @DeleteMapping("/api/links/{id}")
    public String deleteEntry(@PathVariable long id, @RequestBody DeleteInput deleteInput, HttpServletResponse res) throws IOException {

        if(entrySvc.getEntryById(id) != null && entrySvc.getEntryById(id).getSecretCodeAsInt() == (deleteInput.getSecretCode())) {
            entrySvc.deleteEntryById(id);
            res.setStatus(204);
            return null;
        }
        else if (entrySvc.getEntryById(id) != null){
            res.sendError(403);
            return null;
        }
        else {
            res.sendError(404);
            return null;
        }

    }
}

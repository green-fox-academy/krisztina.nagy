package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.Service.PostService;
import com.greenfoxacademy.reddit.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    private PostService postSvc;

    @Autowired
    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/")
    public String index (Model model) {
        model.addAttribute("posts", postSvc.getAll());
        return "index";
    }

    @GetMapping ("/newpost")
    public String createPost (Model model) {
        model.addAttribute("post", new Post());
        return "newpost";
    }

    @PostMapping("/newpost")
    public String addPost (@ModelAttribute Post post) {
        postSvc.addPost(post);
        return "redirect:/";
    }

}


package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.Service.PostService;
import com.greenfoxacademy.reddit.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    private PostService postSvc;

    @Autowired
    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
        postSvc.addPost(new Post("Üzi", "url"));
    }

    @GetMapping("/")
    public String index (Model model) {
        model.addAttribute("posts", postSvc.getAll());
        return "index";
    }
}

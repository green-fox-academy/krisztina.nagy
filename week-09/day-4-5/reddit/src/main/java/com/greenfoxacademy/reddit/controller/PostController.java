package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.Service.PostService;
import com.greenfoxacademy.reddit.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private PostService postSvc;

    @Autowired
    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/")
    public String index (Model model, @RequestParam(required = false, defaultValue = "0") int pageId ) {
        List<Post> myPage = postSvc.getAll(pageId);
        List<Post> peekPage = postSvc.getAll(pageId+1);
        model.addAttribute("posts", myPage);
        model.addAttribute("nextPageId", peekPage.size()>0 ? pageId+1 : pageId);
        model.addAttribute("prevPageId", pageId>0 ? pageId-1 : pageId);
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


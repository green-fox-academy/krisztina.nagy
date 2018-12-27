package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class VoteController {

private PostService postSvc;

@Autowired
public VoteController(PostService postSvc) {
    this.postSvc=postSvc;
}

    @GetMapping("/{id}/upvote")
    public String upVotePost (@PathVariable long id) {

    postSvc.incrementRating(id, new Date());
        return "redirect:/";
    }

    @GetMapping ("/{id}/downvote")
    public String downVotePost (@PathVariable long id) {
        postSvc.decrementRating(id, new Date());
        return "redirect:/";
    }
}


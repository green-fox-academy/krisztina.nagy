package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.Service.PostService;
import com.greenfoxacademy.reddit.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class VoteController {

  private PostService postSvc;

  @Autowired
  public VoteController(PostService postSvc) {
    this.postSvc = postSvc;
  }

  @GetMapping("/{id}/upvote")
  public String upVotePost(@PathVariable long id, @RequestParam int pageId) {
    postSvc.incrementRating(id, new Date());
    return "redirect:/?pageId=" + pageId;
  }

  @GetMapping("/{id}/downvote")
  public String downVotePost(@PathVariable long id, @RequestParam(defaultValue = "0") int pageId) {
    postSvc.decrementRating(id, new Date());
    return "redirect:/?pageId=" + pageId;
  }
}


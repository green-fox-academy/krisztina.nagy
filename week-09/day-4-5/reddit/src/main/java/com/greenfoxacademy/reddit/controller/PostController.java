package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.Service.PostService;
import com.greenfoxacademy.reddit.Service.UserService;
import com.greenfoxacademy.reddit.model.Post;
import com.greenfoxacademy.reddit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PostController {

    private PostService postSvc;
    private UserService userSvc;

    @Autowired
    public PostController(PostService postSvc, UserService userSvc) {
        this.postSvc = postSvc;
        this.userSvc = userSvc;
    }



    @GetMapping("/")
    public String index (Model model, @RequestParam(required = false, defaultValue = "0") int pageId, HttpServletRequest request) {
        List<Post> myPage = postSvc.getAll(pageId);
        List<Post> peekPage = postSvc.getAll(pageId+1);

        //model.addAttribute("nextPageId", peekPage.size()>0 ? pageId+1 : pageId);
        //model.addAttribute("prevPageId", pageId>0 ? pageId-1 : pageId);

        //@SuppressWarnings("unchecked")
        model.addAttribute("actualUser", userSvc.findUserByIdEquals((long)request.getSession().getAttribute("userId")));
        model.addAttribute("posts", myPage);
        model.addAttribute("pageId", pageId);
        model.addAttribute("isLastPage", peekPage.size()==0);
        return "index";
    }

    @GetMapping ("/newpost")
    public String createPost (Model model) {
        model.addAttribute("post", new Post());
        return "newpost";
    }

    @PostMapping("/newpost")
    public String addPost (@ModelAttribute Post post, HttpServletRequest request) {
        User actualUser = userSvc.findUserByIdEquals((long)request.getSession().getAttribute("userId"));
        post.setUser(actualUser);
        postSvc.addPost(post);
        return "redirect:/";
    }

}


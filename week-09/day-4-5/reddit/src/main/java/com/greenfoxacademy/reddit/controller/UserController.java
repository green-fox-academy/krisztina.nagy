package com.greenfoxacademy.reddit.controller;

import com.greenfoxacademy.reddit.Service.UserService;
import com.greenfoxacademy.reddit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

  private UserService userSvc;
  private String userName;

  @Autowired
  public UserController(UserService userSvc) {
    this.userSvc = userSvc;
  }

  @GetMapping("/login")
  public String viewLogin() {
    return "login";
  }

  @PostMapping(value = "/login",
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String postLogin(@RequestBody MultiValueMap<String, String> formData, HttpServletRequest request) {
    User actualUser = userSvc.findUserByUserName(formData.toSingleValueMap().get("user-name"));
    if (actualUser != null) {
      request.getSession().setAttribute("userId", actualUser.getId());
      return "redirect:/";
    } else {
      return "redirect:/register";
    }
  }

  @GetMapping("/register")
  public String createUser(Model model) {
    model.addAttribute("newUser", new User());
    return "register";
  }

  @PostMapping("/register")
  public String addUser(@ModelAttribute User newUser) {
    if (userSvc.findUserByUserName(newUser.getUserName()) == null) {
      userSvc.addUser(newUser);
      return "redirect:/login";
    } else {
      return "redirect:/login";
    }
  }

  @GetMapping("/exterminate")
  public String destroySession(HttpServletRequest request) {
    request.getSession().invalidate();
    return "redirect:/";
  }
}

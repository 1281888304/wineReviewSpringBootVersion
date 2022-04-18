package com.example.wines.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

  @RequestMapping("/")
  @ResponseBody
  public String home() {
    String currentUser= SecurityContextHolder.getContext().getAuthentication().getName();
    return "Dear user "+currentUser;
  }

}

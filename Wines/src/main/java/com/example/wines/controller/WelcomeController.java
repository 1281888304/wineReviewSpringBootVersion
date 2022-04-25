package com.example.wines.controller;

import java.util.Map;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

  @RequestMapping("/")

  public String home(Map<String,Object> map) {
    String currentUser= SecurityContextHolder.getContext().getAuthentication().getName();
    map.put("username",currentUser);
    return "home";
  }

}

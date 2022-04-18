package com.example.wines.controller;

import com.example.wines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
  @Autowired
  UserService userService;
  @GetMapping("/register")
  //registerController用户注册接口,将所有角色信息数据库取值并绑定roles赋给前端registerPage.html
  public ModelAndView resgister() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("roles", userService.getAllRole());
    mv.setViewName("registerPage");
    return mv;


  }




}

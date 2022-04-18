package com.example.wines.controller;


import com.example.wines.pojo.UserRegister;
import com.example.wines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoRegisterController {

  @Autowired
  UserService userService;
  @PostMapping("/doregister")
  public String doregister(UserRegister userRegister){
    return userService.addUserByUsername(userRegister);
  }

  @GetMapping("/admin/hello")
  public String admin(){
    return "hello admin";
  }

  @GetMapping("/db/hello")
  public String dba(){
    return "hello dba";
  }





}

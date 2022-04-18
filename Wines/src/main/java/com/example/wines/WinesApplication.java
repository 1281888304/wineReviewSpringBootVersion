package com.example.wines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication

//@ComponentScan("com.example.wines.mapper")
public class WinesApplication {

  public static void main(String[] args) {
    SpringApplication.run(WinesApplication.class, args);
  }

}

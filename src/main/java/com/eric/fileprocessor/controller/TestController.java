package com.eric.fileprocessor.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  
  @RequestMapping("/hello")
  public String greeting(@RequestParam(value="name") String name) {
    return "Hello " + name;
    
  }
}

package com.mingjie.my_web.controller.front;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hel")
    public String hello(){
        return "welcome to you";
    }
}

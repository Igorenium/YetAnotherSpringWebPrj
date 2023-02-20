package ru.kartashov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping("/hello")
    public String hello() {
        return "main/hello";
    }
    
    @GetMapping("/goodbye")
    public String goobdye() {
        return "main/goodbye";
    }
}
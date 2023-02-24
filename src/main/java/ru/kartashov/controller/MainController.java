package ru.kartashov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "surname", required = false) String surname) {

        System.out.println("Hello, " + name + " " + surname);

        return "main/hello";
    }
    
    @GetMapping("/goodbye")
    public String goobdye() {
        return "main/goodbye";
    }
}
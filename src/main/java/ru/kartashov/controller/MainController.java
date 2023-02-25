package ru.kartashov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "surname", required = false) String surname,
                        Model model) {

        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "main/hello";
    }
    
    @GetMapping("/calculator")
    public String calculator(@RequestParam("oper") String operator,
                             @RequestParam("a") int a,
                             @RequestParam("b") int b,
                             Model model) {
        String result = "Result of " + operator + ": ";
        switch (operator) {
            case "addition":
                result += a + b;
                break;
            case "subtraction":
                result += a -b;
                break;
            case "multiplication":
                result += a * b;
                break;
            case "division":
                result += a / b;
                break;
            default:
                return "main/error";
        }
        model.addAttribute("result", result);
        return "main/calculator";
    }
}
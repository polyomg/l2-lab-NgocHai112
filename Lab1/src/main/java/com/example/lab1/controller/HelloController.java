package com.example.lab1.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    /*Bai 1 */
    /*@RequestMapping("/hello")
    public String hello() {
        return "hello"; // trả về hello.html
    }*/
    /*Demo Slide*/
    @RequestMapping("/hello")
    public String hello(Model  model) {
        model.addAttribute("title", "Nguyen Ngoc Hai");
        model.addAttribute("subject", "Spring Boot MVC");
        return "hello";
    }
}
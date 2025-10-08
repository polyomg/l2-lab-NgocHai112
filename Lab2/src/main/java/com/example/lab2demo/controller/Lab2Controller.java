package com.example.lab2demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Lab2Controller {

    @GetMapping("/lab2")
    public String lab2Home() {
        return "index"; // trả về trang menu Lab 2
    }
}

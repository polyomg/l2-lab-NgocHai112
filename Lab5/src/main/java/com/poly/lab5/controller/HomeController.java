package com.poly.lab5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "/lab5", "/lab5/bai1"})
    public String index() {
        return "index";
    }
}
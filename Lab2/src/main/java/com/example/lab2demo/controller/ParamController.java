package com.example.lab2demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {

    @GetMapping("/param/form")
    public String form() {
        return "param";
    }

    @PostMapping("/param/save/{x}")
    public String save(@PathVariable String x,       // lấy từ đường dẫn
                       @RequestParam String y,       // lấy từ form
                       Model model) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        return "param";
    }
}

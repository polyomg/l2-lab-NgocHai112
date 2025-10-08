package com.example.lab2demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OkController {

    @PostMapping("/ctrl/ok")       // Nút OK 1
    public String m1(Model model) {
        model.addAttribute("methodName", "Bạn vừa gọi m1() - POST");
        return "ok";
    }

    @GetMapping("/ctrl/ok")        // Nút OK 2
    public String m2(Model model) {
        model.addAttribute("methodName", "Bạn vừa gọi m2() - GET");
        return "ok";
    }

    @RequestMapping(value="/ctrl/ok", params="x")  // Nút OK 3
    public String m3(Model model) {
        model.addAttribute("methodName", "Bạn vừa gọi m3() - có param x");
        return "ok";
    }
}

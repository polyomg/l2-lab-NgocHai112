package com.example.lab2demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {

    @GetMapping("/a")
    public String a() {
        return "a";
    }

    @GetMapping("/b")
    public String b(Model model) {
        model.addAttribute("message", "Tôi đến từ b (forward)");
        return "forward:/a";
    }

    @GetMapping("/c")
    public String c(RedirectAttributes params) {
        params.addAttribute("message", "Tôi đến từ c (redirect)");
        return "redirect:/a";
    }

    @ResponseBody
    @GetMapping("/d")
    public String d() {
        return "Tôi đến từ d (ResponseBody)";
    }
}

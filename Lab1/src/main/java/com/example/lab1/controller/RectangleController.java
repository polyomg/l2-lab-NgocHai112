package com.example.lab1.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RectangleController {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/rect/form")
    public String form() {
        return "rect";
    }

    @PostMapping("/rect/calc")
    public String calc(Model model) {
        try {
            double length = Double.parseDouble(request.getParameter("length"));
            double width = Double.parseDouble(request.getParameter("width"));
            model.addAttribute("area", length * width);
            model.addAttribute("perimeter", 2 * (length + width));
        } catch (Exception e) {
            model.addAttribute("area", null);
            model.addAttribute("perimeter", null);
        }
        return "rect";
    }
}

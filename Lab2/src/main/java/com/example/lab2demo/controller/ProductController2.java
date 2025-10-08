package com.example.lab2demo.controller;

import com.example.lab2demo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController2 {
    private List<Product> items = new ArrayList<>();

    public ProductController2() {
        // Khởi tạo danh sách mẫu ban đầu
        items.add(new Product("A", 1.0));
        items.add(new Product("B", 12.0));
    }

    @GetMapping("/product2/form")
    public String form(Model model) {
        Product product1 = new Product("iPhone 30", 5000.0);
        model.addAttribute("product1", product1);
        model.addAttribute("items", items);
        return "product2";
    }

    @PostMapping("/product2/save")
    public String save(@ModelAttribute("product2") Product p, Model model) {
        items.add(p);
        model.addAttribute("product2", p);
        model.addAttribute("product1", new Product("iPhone 30", 5000.0));
        model.addAttribute("items", items);
        return "product2";
    }
}

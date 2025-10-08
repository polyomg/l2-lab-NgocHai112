package com.example.lab1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    HttpServletRequest request;

    @GetMapping("/login/form")
    public String form() {
        return "login";
    }
    @PostMapping("/login/check")
    public String login(Model model) {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("poly".equals(user) && "123".equals(pass)) {
            //model.addAttribute("message", "Xin chào " + user + ", đăng nhập thành công!");
            model.addAttribute("username", user);
            return "trangchu";
        } else {
            model.addAttribute("message", "Xin lỗi " + user + ", tài khoản hoặc mật khẩu không đúng!");
        }
        return "login";
    }
}
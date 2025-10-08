package com.poly.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.poly.lab5.service.CookieService;
import com.poly.lab5.service.ParamService;
import com.poly.lab5.service.SessionService;

@Controller
public class AccountController {

    @Autowired ParamService paramService;
    @Autowired CookieService cookieService;
    @Autowired SessionService sessionService;

    @GetMapping("/account/login")
    public String loginForm() {
        return "/account/login";
    }

    @PostMapping("/account/login")
    public String loginProcess(Model model) {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        if (username.equals("poly") && password.equals("123")) {
            sessionService.set("username", username); //lưu username vào session
            if (remember) {
                cookieService.add("user", username, 240); // 10 ngày
            } else {
                cookieService.remove("user");
            }
            model.addAttribute("message", "Đăng nhập thành công!");
        } else {
            model.addAttribute("message", "Sai tài khoản hoặc mật khẩu!");
        }

        return "/account/login";
    }
}
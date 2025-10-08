package com.poly.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.poly.lab5.service.ParamService;

import java.io.File;

@Controller
public class RegisterController {

    @Autowired
    ParamService paramService;

    @GetMapping("/account/register")
    public String registerForm() {
        return "/account/register";
    }

    @PostMapping("/account/register")
    public String registerProcess(Model model,
                                  @RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  @RequestParam("photo_file") MultipartFile photoFile) {

        // 1️⃣ Lưu file ảnh vào thư mục /static/photos
        File savedFile = paramService.save(photoFile, "/photos/");

        // 2️⃣ Thông báo kết quả
        if (savedFile != null) {
            model.addAttribute("message",
                    "Đăng ký thành công cho tài khoản: " + username +
                            "<br>Ảnh đã lưu: " + savedFile.getName());
        } else {
            model.addAttribute("message",
                    "Không có file upload hoặc lỗi khi lưu file!");
        }

        return "/account/register";
    }
}
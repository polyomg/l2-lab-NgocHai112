package com.example.lab3.controller;

import com.example.lab3.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.GregorianCalendar;
@Controller
public class StaffController {

    // Bài 1: Hiển thị 1 Staff
    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("nguyễn văn user")
                .photo("ảnh hồ sơ.jpg")
                .gender(true)
                .birthday(new GregorianCalendar(2003, Calendar.MARCH, 15).getTime())
                .salary(98765.4321)
                .level(2)
                .build();
        model.addAttribute("staff", staff);
        return "staff-detail";
    }

    // Bài 2: Danh sách Staff
    @RequestMapping("/staff/list")
    public String list(Model model) {
        List<Staff> list = List.of(
                Staff.builder()
                        .id("u1@gmail.com")
                        .fullname("nguyễn văn a")
                        .level(0)
                        .salary(10000.0)
                        .build(),
                Staff.builder().id("u2@gmail.com").fullname("trần thị b").level(1).salary(15000.0).build(),
                Staff.builder().id("u3@gmail.com").fullname("lê văn c").level(2).salary(20000.0).build()
        );
        model.addAttribute("list", list);
        return "staff-list";
    }

    // Bài 4: Trạng thái vòng lặp
    @RequestMapping ("/staff/status")
    public String status(Model model) {
        List<Staff> list = List.of(
                Staff.builder().fullname("nguyễn văn a").build(),
                Staff.builder().fullname("trần thị b").build(),
                Staff.builder().fullname("lê văn c").build(),
                Staff.builder().fullname("phạm thị d").build()
        );
        model.addAttribute("list", list);
        return "list-status";
    }

    // Bài 5: SelectBox + Radio
    @RequestMapping("/staff/controls")
    public String controls(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("A").fullname("Nguyễn Văn A").level(0).build(),
                Staff.builder().id("B").fullname("Trần Thị B").level(1).build(),
                Staff.builder().id("C").fullname("Lê Văn C").level(2).build()
        );
        model.addAttribute("list", list);
        return "list-controls";
    }
    @GetMapping("/lab3")
    public String index() {
        return "index";
    }

}
